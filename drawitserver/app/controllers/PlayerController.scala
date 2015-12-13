package controllers

import play.api.mvc.{Action, Controller}
import models._

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

/**
  * @author oguzb
  */
class PlayerController extends Controller {

  implicit val loginReads: Reads[LoginPlayer] = (
    (JsPath \ "username").read[String] and
    (JsPath \ "password").read[String] and
    (JsPath \ "addresses").read[List[String]] and
    (JsPath \ "preferredAddress").read[String]
    )(LoginPlayer.apply _)

  def login = Action(parse.json) { implicit request =>
    request.body.validate[LoginPlayer].fold(
      valid = { loginPlayer =>
        Player.fromLoginPlayer(loginPlayer) match {
          case None => Response.NotFound("no such user")
          case Some(p) =>
            p.updateAddresses(loginPlayer)
            Response.Ok("logged in")
        }
      },
      invalid = { errors =>
        Response.BadRequest("missing params")
      }
    )
  }

  def signup = Action(parse.json) { implicit request =>
    request.body.validate[LoginPlayer].fold(
      valid = { loginPlayer =>
        Player.fromLoginPlayer(loginPlayer) match {
          case None =>
            Player.fromSignupPlayer(loginPlayer).signup()
            Response.Ok("signed up")
          case Some(p) =>
            Response.BadRequest("user "+loginPlayer.username+" already exists.")
        }
      },
      invalid = { errors =>
        Response.BadRequest("missing params")
      }
    )
  }

  def lookup(name: String) = Action { implicit request =>
    Player.withUsername(name) match {
      case Some(p) =>
        Ok(Json.obj("addresses" -> p.addresses, "preferredAddress" -> p.preferredAddress))
      case _ =>
        Response.NotFound("no such player")
    }
  }
}
