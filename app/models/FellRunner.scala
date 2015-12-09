package models

/**
 * Created by barn on 09/12/15.
 */
case class Company(name: String, location: String, age: Int)

case class FellRunner(name: String, company: Company)
object FellRunner{
  //    implicit val fellRunnerWrites = Json.format[FellRunner]

}