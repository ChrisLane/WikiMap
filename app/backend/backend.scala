/**
  * Created by misha on 27/12/15.
  */
package object backend {
  case class Coords(lat: Double, long: Double)
  case class SimpleLocation(name: String, coords: Coords, locationType: String)

  case class Event(date: Date, description: String, id: Option[Int] = None)
  case class Date(date: Int, month: Int, year: Int)
  case class LocatedEvent(event: Event, location: SimpleLocation)

  def strip(text: String) = text.toLowerCase().replaceAll("\\W", "")
}
