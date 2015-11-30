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

  def submit = Action {   implicit request =>
    TestForm.form.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.index())
      },
      myFormDto => {
        Ok(myFormDto.toString)

      }
    )
  }
}


object FormsController extends FormsController
