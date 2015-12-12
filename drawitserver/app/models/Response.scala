package models

import play.api.libs.json.Json
import play.api.mvc.Results._

/**
  * @author oguzb
  */

case class Response(status: Status, message: String) {
  def apply = status(Json toJson Map("message" -> message))
}

object Response {

  final def BadRequest(message: String) = new Response(play.api.mvc.Results.BadRequest, message).apply
  final def NotFound(message: String) = new Response(play.api.mvc.Results.NotFound, message).apply
  final def Unauthorized(message: String) = new Response(play.api.mvc.Results.Unauthorized, message).apply
  final def Ok(message: String) = new Response(play.api.mvc.Results.Ok, message).apply
}
