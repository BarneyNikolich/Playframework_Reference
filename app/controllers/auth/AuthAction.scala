package controllers.auth

import controllers.routes
import play.api.mvc._

/**
 * Created by barn on 10/12/15.
 */
trait AuthAction extends Controller {

  /**
   * If the session exists then go to desired path.
   * Else Redirect the User to the log in page.
   * The request is as it comes in... hasn't changed state to a BadRequest or OK.
   * It essentially has access to the block of the action.
   */
  def AuthAction(block: Request[AnyContent] => Result): Action[AnyContent] = {
    Action { request =>
      request.session.get("username") match {
        case Some(user) => block(request)
        case None => Redirect(routes.Application.viewForm())
      }
    }
  }

   /*
    *
    * The below code does what the AuthAction does but you insert this into each method.
    * Rather than AuthAction which is passed as Parameter
    *

    val username = request.session.get("username")
    username match {
      case Some(user) => Ok(views.html.index(user, contentsList))
      case None => Redirect(routes.Application.viewForm())
    }
    */

}
