package controllers

import controllers.auth.AuthAction
import models._


class Application extends AuthAction {

  val contentsList = List("Template Engine Examples","Form Revision","Basic Json Parsing",
                          "Lists", "Asynchronous HTTP programming","Template Wrapper Example")

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





}
object Application extends Application
