/**
  * Created by misha on 27/12/15.
  */
package object backend {

  val months = Seq(
    "January", "February", "March",
    "April", "May", "June",
    "July", "August", "September",
    "October", "November", "December")

  case class Coords(lat: Double, long: Double)
  case class Location(name: String, coords: Coords, locationType: String)

  case class Event(date: Date, wikiPage: Option[String], desc: String)
  case class LocatedEvent(event: Event, location: Location)
  case class Date(date: Int = 1, month: Int = 1, year: Int = 1, precision: DatePrecision = PreciseToDate) {
    override def toString: String = precision match {
      case PreciseToDate => s"Date($date/$month/$year)"
      case PreciseToMonth => s"Date($month/$year)"
      case PreciseToYear => s"Date($year)"
      case NotPrecise => "Date(N/A)"
    }
  }

  sealed trait DatePrecision
  case object PreciseToYear extends DatePrecision
  case object PreciseToMonth extends DatePrecision
  case object PreciseToDate extends DatePrecision
  case object NotPrecise extends DatePrecision

  def strip(text: String) = text.toLowerCase().replaceAll("\\W", "")
}
