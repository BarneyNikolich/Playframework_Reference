package controllers


import models.dto.TestForm
import play.api.mvc.{Controller, Action}
import play.api.Play.current
import play.api.i18n.Messages.Implicits._


/**
 * Created by barn on 30/11/15.
 */
class FormsController extends Controller {


  def viewForm = Action {
    Ok(views.html.forms.showForm(TestForm.form))
  }

  def submit = Action { implicit request =>
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
