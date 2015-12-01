package models.dto

import org.joda.time.LocalDate
import play.api.data.Forms._
import play.api.data.Form

/**
 * Created by barn on 30/11/15.
 */
case class TestForm(text: String,
                    optionalText: Option[String],
                    number: Int,
                    select: Int,
                    radioBtn: String,
                    date: LocalDate,
                    password: String,
                    confirmPassword: String,
                    tickBox: Boolean)

object TestForm {

  val form = Form(
    mapping(
      "text" -> nonEmptyText,
      "optionalText" -> optional(text),
      "number" -> number,
      "select" -> number,
      "radioBtn" -> text,
      "date" -> jodaLocalDate.verifying("Date must be in the past!", d => d.isBefore(LocalDate.now.plusDays(1))),
      "password" -> text(8, 15),
      "confirmPassword" -> text(8, 15),
      "tickBox" -> boolean.verifying("Must click the tick box!", c => c.equals(true))
    ) (TestForm.apply)(TestForm.unapply).verifying("Passwords must match", field => field.password.equals(field.confirmPassword))
  )

}
