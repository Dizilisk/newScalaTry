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

  def nFlights(network: Map[String, Set[String]], location: String): Int = {
    network(location).size
  }

  def mostFlights(network: Map[String, Set[String]]): String = {
    network.maxBy(_._2.size)._1

  }

  def nLocationsWithNoFlights(network: Map[String, Set[String]]): Int = {
    network.view.filterKeys(key => network(key).isEmpty).size
  }

  def isConnected(network: Map[String, Set[String]], pointA: String, pointB: String): Boolean = {

    def loop2(target: String, setA: Set[String], setB: Set[String]): Boolean = {
      if (setB.isEmpty) false
      else {

        if (setB.head == target) true
        else if (setA.contains(setB.head)) {
          true
        } else {
          loop2(target, setA + setB.head, setB.tail ++ network(setB.head))
        }
      }

    }
    loop2(pointA, network(pointA), network(pointB))
  }

  val list: Map[String, Set[String]] = Map("a" -> Set(), "b" -> Set(), "c" -> Set(), "d" -> Set())
  println("пустой список list: " + list)
  val list1 = connect(list, "a", "b")
  println("соединение а и b list1: " + list1)
  val list2 = connect(list1, "b", "d")
  println("соединение b и d list2: " + list2)
  val list3 = connect(list2, "a", "c")
  println("соединение a и c list3: " + list3)
  val list4 = remove(list3, "c")
  println("удаление c list4: " + list4)
  val list5 = disconnect(list4, "a", "b")
  println("разъединение a и b list5: " + list5)

  println("количество прямых перелетов list2: " + nFlights(list2, "b"))

  println("проверка на пустые точки list5: " + nLocationsWithNoFlights(list5))

  println("проверка на самое большое количество перелетов list3: " + mostFlights(list3))

  println("проверка на связь между точками list 2: " + isConnected(list2, "a", "b"))


  val x1: (String, Map[Nothing, Nothing]) = "c" -> Map()
  val x2: (String, Map[String, Map[Nothing, Nothing]]) = "b" -> Map(x1)
  val x3: (String, Map[String, Map[String, Map[Nothing, Nothing]]]) = "a" -> Map(x2)

}
