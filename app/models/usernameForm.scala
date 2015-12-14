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
      "name" -> nonEmptyText.verifying("Must not contain numbers!", c => c.matches("[a-zA-Z]*"))
        .verifying("Must be between 4 and 10 characters", s => s.matches("[a-zA-Z]{4,10}"))
    ) (UserData.apply) (UserData.unapply)
  )
}