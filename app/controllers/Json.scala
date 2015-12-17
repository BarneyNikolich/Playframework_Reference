package controllers

import controllers.auth.AuthAction
import play.api.libs.json.Json
import play.api.libs.json._
import play.api.mvc.Action


/**
 * Created by barn on 04/12/15.
 */
class Json extends AuthAction {

  def index = AuthAction { implicit request =>
    Ok(views.html.json.jsonHome())
  }

  case class Person(name: String)
  object Person{
    implicit val personWrites = Json.format[Person] //Creates an implicit writes val. The implicit val toJson call requires
  }


  /**
   * Long winded way to create Json
   */
  val json: JsValue = Json.parse("""
{
  "name" : "Watership Down",
  "location" : {
    "lat" : 51.235685,
    "long" : -1.309197
  },
  "residents" : [ {
    "name" : "Fiver",
    "age" : 4,
    "role" : null
  }, {
    "name" : "Bigwig",
    "age" : 6,
    "role" : "Owsla"
  } ]
}
""")

  /**
   * Use Json Object
   */
  val jsonObj: JsValue = Json.obj(
    "name"->"Fell Runners",
    "location"->"United Kingdom",
    "runners"-> Json.arr(
      Json.obj(
        "name" -> "Barney Nikolich",
        "age" -> "21",
        "shoe" -> "SpeedCross 3"
      ),
      Json.obj(
        "name" -> "Mike Sellors",
        "age"  -> "22",
        "shoe" -> "Pelegrines"
      )
    )
  )

  /**
   * Converting from Scala to Json
   */
  case class Runner(name: String, age: Int, shoe: String)
  object Runner {
    implicit val runnersWrite = Format(Json.reads[Runner], Json.writes[Runner])
  }

  case class FellRunners(runners: List[Runner])
  object FellRunners {
    implicit val fellRunnersWrite = Format(Json.reads[FellRunners], Json.writes[FellRunners])
  }

  val fellRunners = FellRunners(List(Runner("Jezz Bragg", 43, "North Face"),
    Runner("Joss Naylor", 76, "Keswick"), Runner("Karren Nash", 48, "Run Further")))

  def listRunnersToJson = Action { request =>
    val listOfRunnersAsJson = Json.toJson(fellRunners)
    println(listOfRunnersAsJson)
    Ok(views.html.json.showRunnersAsJson(listOfRunnersAsJson))
  }

  case class RealPerson(name: String, age: Int)

  val personsList = List(
    RealPerson("Barney Nikolich", 21),
    RealPerson("Sushil", 33),
    RealPerson("Anonymous", 22),
    RealPerson("John Densmore", 33)
  )

  //  Converts the local list personsList to json
  def returnListOfPeople = Action { request =>
    implicit val listWrites = Json.format[RealPerson] //Implicit writes val of type RealPersons is required to convert to JSON.
    val listOfPeopleAsJson = Json.toJson(personsList) //Takes secon implicit value as declared line above
    Ok("JSON SHOULD RETURN LIST OF PEOPLE: " + listOfPeopleAsJson + request)
  }

  val numbers = Seq(1, 3, 55, 6, 77, 85, 3)

  def seqNumbers = Action {
    val seqJson = Json.toJson(numbers)
    Ok(views.html.json.showRunnersAsJson(seqJson))
  }





}
