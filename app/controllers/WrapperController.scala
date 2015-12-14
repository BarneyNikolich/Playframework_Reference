package controllers

import controllers.auth.AuthAction
import play.api.mvc.{AnyContent, Request}

/**
 * Created by barn on 14/12/15.
 */
class WrapperController extends AuthAction {

  private def currentUrl(implicit request: Request[AnyContent]) =
    "loalhost:9000/" + request.path


  def index = AuthAction { implicit request =>
    Ok(views.html.interstitial.showWrappers())
  }

  def displayPage1 = AuthAction { implicit request =>
  Ok(views.html.interstitial.page1(currentUrl, "Page1", "Page 1"))
  }

  def displayPage2 = AuthAction { implicit request =>
    Ok(views.html.interstitial.page2(currentUrl, "Page2", "Page 2"))
  }

  def displayPage3 = AuthAction { implicit request =>
    Ok(views.html.interstitial.page3(currentUrl, "Page3", "Page 3"))
  }

//  def displayPensions =  {
//    implicit pertaxUser => implicit request =>
//      formPartialService.getPensionPartial.map(p =>
//        Ok(views.html.interstitial.viewPensionsSummarInterstitial(formPartial = p successfulContentOrElse Html(""), redirectUrl = currentUrl))
//      )
//  }



}
