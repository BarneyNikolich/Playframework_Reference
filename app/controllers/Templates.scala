package controllers

import play.api.mvc._
import play.api.mvc.Action
import models._

/**
 * Created by barn on 09/12/15.
 */
class Templates extends Controller {

  val runners = List(
      FellRunner("Joss Naylor", Company("inov-8", "Durham", 50)),
      FellRunner("Bob Graham", Company("Pete Bland", "Cumbria", 2)),
      FellRunner("Jezz Bragg", Company("The North Face", "Pennines", 30))
  )

  def index = Action {
    Ok(views.html.template(runners, models.User("Barn")))
  }



}
