package models

import anorm.SqlParser._
import anorm._
import play.Play
import play.api.Play.current
import play.api.db.DB
import play.api.libs.Codecs

/**
  * @author oguzb
  */

case class LoginPlayer(username: String, password: String, addresses: List[String], preferredAddress: String)

object Player {
  def withUsername(uname: String): Option[Player] = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM Player WHERE username = {uname}")
        .on("uname" -> uname)
        .as(playerMapping *)
        .headOption
    }
  }

  def withUsernameAndPassword(uname: String, pword: String): Option[Player] = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM Player WHERE username = {uname} AND password = {pword}")
        .on("uname" -> uname, "pword" -> pword)
        .as(playerMapping *)
        .headOption
    }
  }

  val playerMapping = {
    get[Long]("id") ~
      get[String]("username") ~
      get[String]("password") ~
      get[List[String]]("addresses") ~
      get[String]("preferred_address") ~
      get[Int]("highscore") map {
      case id ~ username ~ password ~ addresses ~ preferredAddress ~ highScore =>
        new Player(id, username, password, addresses, preferredAddress, highScore)
    }
  }

  def fromLoginPlayer(loginPlayer: LoginPlayer): Option[Player] =
    Player.withUsernameAndPassword(loginPlayer.username, hashPassword(loginPlayer.password))

  def fromSignupPlayer(signupPlayer: LoginPlayer): Player =
    new Player(0, signupPlayer.username, Player.hashPassword(signupPlayer.password), signupPlayer.addresses, signupPlayer.preferredAddress, 0)

  def hashPassword(password: String) =
    Codecs.sha1(password + Play.application().configuration().getString("player.salt") )
}

class Player(val id: Long,
             val username: String,
             val password: String,
             val addresses: List[String],
             val preferredAddress: String,
             val highScore: Int) {

  def hashedPassword() = Player.hashPassword(password)
  def withHashedPassword = new Player(id, username, hashedPassword(), addresses, preferredAddress, highScore)

  def updateAddresses(loginPlayer: LoginPlayer, remoteAddress: String) = {
    DB.withConnection { implicit connection =>
      // danger: un-sanitized input
      // Must find a better way to work with PostgreSQL arrays in Anorm
      val addressStr = ((loginPlayer.addresses :+ remoteAddress).foldLeft("{")((s, a) => s + a + ",")+"}").replace(",}", "}")
      SQL("UPDATE player SET preferred_address = {preferredAddress}, addresses='"+addressStr+"' WHERE id = {id}")
      .on("id" -> id, "preferredAddress" -> loginPlayer.preferredAddress)
      .executeInsert()
    }
  }

  def signup(remoteAddress: String) = {
    DB.withConnection { implicit connection =>
      // danger: un-sanitized input
      val addressStr = ((addresses :+ remoteAddress).foldLeft("{")((s, a) => s + a + ",")+"}").replace(",}", "}")
      SQL("INSERT INTO player VALUES (default, {username}, {password}, {highscore}, {preferredAddress}, '"+addressStr+"')")
        .on("username" -> username, "password" -> password,
            "highscore" -> highScore, "preferredAddress" -> preferredAddress)
        .executeInsert()
    }
  }
}
