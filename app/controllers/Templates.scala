package controllers

import play.api.mvc._
import play.api.mvc.Action
import models._
import FormsController.AuthAction

/**
 * Created by barn on 09/12/15.
 */
class Templates extends Controller {

  val runners = List(
      FellRunner("Joss Naylor", Company("inov-8", "Durham", 50)),
      FellRunner("Bob Graham", Company("Pete Bland", "Cumbria", 2)),
      FellRunner("Jezz Bragg", Company("The North Face", "Pennines", 30))
  )

  def templates = AuthAction { implicit request =>
    println(">>>>>>>>>>>>" + request.session.get("username").getOrElse("Not found") + " <<<<<<<<<<<<<")
    Ok(views.html.template(runners))
    /*val currentUser = request.session.get("username")
    currentUser match {
      case Some(user) => Ok(views.html.template(runners))
      case None => Redirect(routes.Application.viewForm())
    }*/
  }





}
