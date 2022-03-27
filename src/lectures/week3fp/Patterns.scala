package lectures.week3fp

object Patterns extends App {

  val someVal = 3
  val description = someVal match {
    case 1 => "action 1"
    case 2 => "action 2"
    case 3 => "action three"
    case _ => "default action"
  }

  println(description)

  /* Константы */

  val x: Any = "Scala"
  val constants = x match {
    case 1 => "число"
    case "Scala" => "строка"
    case true => "булевое значение"
  }

  /* Туплы */

  val aTuple = (5, 2)
  val matchATuple = aTuple match {
    case (1, 1) => "полное совпадение"
    case (something, _) => s"я нашел $something"
  }
  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) => s"тут есть число $v"
  }

  println(matchATuple)
  println(matchNestedTuple)

  /* Списки */

  val aStandardList = List(5, 4)
  val listMatching = aStandardList match {
    case List(1, _, _, _) => "Список из 4 элементов, где первый элемент равен 1"
    case List(2, _*) => "Список произвольной длины, где первый элемент равен 2"
    case List(1, 2 , 3) :+ 0 => "Список List(1, 2, 3, 0)"
    case 5 :: List(_) => "Список, где первым идет число 5 и ещё один элемент"
    case _ => "default"
  }

  /* Типы */

  val unknown: Any = List(1, 2 )
  val typeMatch = unknown match {
    case list: List[Int] => "list of INTs"
    case _ => "default"
  }

  println(typeMatch)

  /* Классы образцы */

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 30)
  val greetings = bob match {
    case Person(n, a) if a < 18 => s"I'm $n and I'm under 18"
    case Person(n, a) if n != "name" => s"I'm $n and I am $a years old"
    case _ => "I have no name"
  }

  println(greetings)

  /* Привязка имен */

  val nameBindingMatch = List(6, 2) match {
    case nonEmptyList@List(1, _, _, _) => s"нашли $nonEmptyList"
    case someList@List(6, _) => s"нашли список $someList"
  }

  println(nameBindingMatch)


  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listIfNumbers: List[Int] => "a list of integers"
    case _ => "default case"
  }

  println(numbersMatch)

  def guard(data: Any, maxLength: Int): String = data match {
    case data: List[Any] if data.length <= maxLength => "Задан список List допустимой длины"
    case data: List[Any] if data.length > maxLength => "Длина списка больше максимально допустимого значения"
    case data: String if data.length <= maxLength => "Длина строки не превышает максимально допустимого значения"
    case data: String if data.length > maxLength => "Получена строка недопустимой длины"
    case _ => "Что это? Это не строка и не список"
  }

  val string = "Hello World"
  val string1 = string.split(" ").toList.flatMap(_.take(1)).mkString("", ". ", ". ")
  println(string1)
}
