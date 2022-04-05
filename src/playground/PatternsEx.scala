package playground

import scala.annotation.tailrec
import scala.io.StdIn.readLine


object PatternsEx {

    def main(args: Array[String]): Unit = {
    }

  val stringName1: String = readLine()
  val string1: String = {
    if (stringName1 == null) "Oops, something is wrong"
    else stringName1.split(" ").toList.flatMap(_.take(1)).mkString("", ". ", ".")
  }

  println(string1)


  val v1: String = "1.0.4.2"
  val v2: String = "1.0.4.2.3"
  val m1: List[String] = v1.split('.').toList
  val m2: List[String] = v2.split('.').toList
  @tailrec
  def loop(a: List[String], b: List[String]): Int = {
    if (loopAtOneList(a) || loopAtOneList(b)) {
      if (loopAtOneList(a) && loopAtOneList(b)) 0
      else if (loopAtOneList(a)) -1
      else 1
    } else if (a.head.toInt < b.head.toInt) -1
    else if (a.head.toInt > b.head.toInt) 1
    else loop(a.tail, b.tail)
  }

  def loopAtOneList(list: List[String]): Boolean = list.forall(_ == "0")

  loop(m1, m2)

}