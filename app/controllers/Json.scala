package controllers

import play.api.libs.json.Json
import play.api.mvc.Controller

/**
 * Created by barn on 04/12/15.
 */
class Json extends Controller {

  def index = TODO


  case class Person(name: String)
  object Person{
    implicit val personWrites = Json.format[Person] //Creates an implicit writes val. The implicit val toJson call requires
  }
















}
