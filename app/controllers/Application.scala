package controllers

import controllers.auth.AuthAction
import models._
import play.api.Play.current
import play.api.i18n.Messages.Implicits._
import play.api.mvc.Action

class Application extends AuthAction {

  val contentsList = List("Template Engine Examples","Form Revision","Basic Json Parsing",
                          "Lists", "Asynchronous HTTP programming")

  def index = AuthAction { implicit request =>
    Ok(views.html.index(contentsList))
    /*
     *  Below section explicitly does what the AuthAction method does!!
     *
     *  val username = request.session.get("username")
     *  username match {
     *  case Some(user) => Ok(views.html.index(user, contentsList))
     *  case None => Redirect(routes.Application.viewForm())
     *   }
     *
     */

  }

  def viewForm = Action {
    Ok(views.html.login(UserData.userForm))

  }

  def submitUsername = Action { implicit request =>
    println("The URI is: " + request.uri)
      UserData.userForm.bindFromRequest.fold(
        errors => {
          println(errors)
          BadRequest(views.html.login(errors))
        },
        success => {
          Redirect(routes.Application.index()).withSession("username" -> success.name)
        }
      )
  }



}
object Application extends Application
