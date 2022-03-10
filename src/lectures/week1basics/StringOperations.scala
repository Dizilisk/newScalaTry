package lectures.week1basics

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
  val y = x.length
  val x1 = x.split(" ").toList
  val x2 = x1.reverse


  def line(b: List[String]): String = {
    def erase(a: Int, acc: String): String = {
      if (a == 0) {
        acc
      } else {
        erase(a - 1, acc))
      }
      erase(line(b))
    }
    line(erase(y, x))
  }
  val x3 = line(x2).mkString(" ")
}
