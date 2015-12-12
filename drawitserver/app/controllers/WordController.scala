package controllers

import anorm._
import play.api.db.DB
import play.api.libs.json.Json
import play.api.Play.current
import play.api.mvc.{Action, Controller}

/**
  * @author oguzb
  */
class WordController extends Controller {

  def limit = 3

  def getRandomWords = Action { request =>
    DB.withConnection { implicit connection =>
      SQL("SELECT content FROM word ORDER BY RANDOM() LIMIT "+limit+";")
      .fold(List[String]())((words, row) => words :+ row[String]("content")) match {
        case Right(words) =>
          Ok(Json.toJson(words))
        case Left(t) =>
          InternalServerError("couln't get random words")
      }
    }
  }
}
