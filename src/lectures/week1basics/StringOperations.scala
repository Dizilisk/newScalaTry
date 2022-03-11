package lectures.week1basics

import scala.annotation.tailrec

object StringOperations extends App {
  val aString: String = "Hello, world!"

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

  val link = "https://stepik.org"
  println(raw"the link is \t $link")
  println(s"The link is $link.toUpperCase")
  //println(link :+'/catalog')
  //println(s"The link is $linc")
  println(link :++ "/catalog")
  println(s"The link is \t $link")
  println(s"The link is link")
  println(s"The link is ${link.toUpperCase}")

  val x = "I like     Scala"
  val x1 = x.split(" ").toList
  val y = x1.length
  println(x1)
  println(y)

  def line(b: List[String]): List[String] = {
    @tailrec
    def erase(a: Int, acc: List[String]): List[String] = {
      if (a == 0) {
        acc.filter(_ != "")
      } else {
        erase(a - 1, acc.map{x => x.replace(" ", "-")})
      }
    }
    erase(y, b)
  }
  println(line(x1))
  val x2 = line(x1).reverse
  val x3 = line(x2).mkString(" ")
  println(x3)
}