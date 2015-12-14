package controllers

import controllers.auth.AuthAction
import models.TestForm
import play.api.mvc._
import play.api.Play.current
import play.api.i18n.Messages.Implicits._

import scala.concurrent.Future


/**
 * Created by barn on 30/11/15.
 */
class FormsController extends AuthAction {

  /**
   * Example of checking whethere there is a session and redirecting without using the AuthAction.
   */
  def viewForm = Action { implicit request =>
    val username = request.session.get("username")
    username match{
      case Some(user) => Ok(views.html.forms.showForm(TestForm.form))
      case None => Redirect(routes.loginController.viewForm())
    }
  }

  def submit = AuthAction { implicit request =>
      TestForm.form.bindFromRequest.fold(
      formWithErrors => {
        println(formWithErrors)
        BadRequest(views.html.forms.showForm(formWithErrors))
      },
        myFormDto => {
          val formResults = List(
//          Scala string Interpolating
            s"textInput: ${myFormDto.text}",
            s"optionTextInput: ${myFormDto.optionalText}",
            s"number: ${myFormDto.number}",
            s"select: ${myFormDto.select}",
            s"radioBtn: ${myFormDto.radioBtn}",
            s"date: ${myFormDto.date}",
            s"password: ${myFormDto.password}",
            s"confirmPassword: ${myFormDto.confirmPassword}",
            s"tickBox: ${myFormDto.tickBox}"
          )
          Redirect(routes.FormsController.formResults(formResults)) //Redirect the submit action to the formResults method. This is a post.
        }
      )
  }

  def formResults(results: List[String]) = Action {
    Ok(views.html.forms.formResults(results))
  }


}

object FormsController extends FormsController
