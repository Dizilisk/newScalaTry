package exercises

object AirplaneTracker extends App {

  def add(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = network + (location -> Set())

  def remove(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
    def loop(destinations: Set[String], acc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (destinations.isEmpty) acc
      else loop(destinations.tail, disconnect(acc, location, destinations.head))
    }

    val disconnected = loop(network(location), network)
    disconnected - location
  }

  def connect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {

    val routesForA: Set[String] = network(pointA)
    val routesForB: Set[String] = network(pointB)

    network + (pointA -> (routesForA + pointB)) + (pointB -> (routesForB + pointA))
  }

  def disconnect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {

    val routesForA: Set[String] = network(pointA)
    val routesForB: Set[String] = network(pointB)

    network + (pointA -> (routesForA - pointB)) + (pointB -> (routesForB - pointA))
  }

  def nFlight(network: Map[String, Set[String]], location: String): Int = {


  }

  def mostFlights(network: Map[String, Set[String]]): String = {


  }

  def nLocationsWithNoFlights(network: Map[String, Set[String]]): Int = {
    network.view.filterKeys(key => network(key).isEmpty).size
  }

  def isConnected(network: Map[String, Set[String]], pointA: String, pointB: String): Boolean = {


  }
}
