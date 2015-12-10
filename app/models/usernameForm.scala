package models

import play.api.data.Form
import play.api.data.Forms._


/**
 * Created by Barn on 09/12/15.
 */

case class UserData(name: String)

object UserData {
  val userForm = Form(
    mapping (
      "name" -> nonEmptyText
    ) (UserData.apply) (UserData.unapply)
  )
}