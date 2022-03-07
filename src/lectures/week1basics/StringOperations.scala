package lectures.week1basics

object StringOperations extends App {
    val aString : String = "Hello, world!"

  println(aString.length)
  println(aString.charAt(1))
  println(aString.substring(0, 2))
  println(aString.split(" ").toList)
  println(aString.startsWith("He"))
  println(aString.replace("!", "."))
  println(aString.toLowerCase)
  println(aString.toUpperCase)
  println("abcd".reverse)
  println("abcd".take(2))
}
