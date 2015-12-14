package controllers

import controllers.auth.AuthAction
import models.UserData
import play.api.Play.current
import play.api.i18n.Messages.Implicits._
import play.api.mvc.Action

/**
 * Created by Barn on 10/12/15.
 */
class loginController extends AuthAction{

  def viewForm = Action {
    Ok(views.html.login(UserData.userForm))
  }

  def submitUsername = Action { implicit request =>
    //println("The URI is: " + request.uri)
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

  def logout = Action {
    Redirect(routes.loginController.viewForm).withNewSession
  }


}
