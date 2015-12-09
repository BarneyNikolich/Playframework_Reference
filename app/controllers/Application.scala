package controllers

import play.api._
import play.api.mvc._
import models._

class Application extends Controller {

  val contentsList = List("Template Engine Examples","Form Revision","Basic Json Parsing",
                          "Lists", "Asynchronous HTTP programming")

  def index = Action {
    val currentUser = User("Barney", "Barn", "password")
    Ok(views.html.index(currentUser, contentsList))
  }

}
object Application extends Application
