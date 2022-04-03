package playground

import scala.annotation.tailrec
import scala.io.StdIn.readLine


object PatternsEx extends App {

//  def main(args: Array[String]): Unit = {
//  }

  /*  val stringName1: String = readLine()
  val string1: String = {
    if (stringName1 == null) "Oops, something is wrong"
    else stringName1.split(" ").toList.flatMap(_.take(1)).mkString("", ". ", ".")
  }

  println(string1)*/










  val v1: String = "1.0.4.2.4"
  val v2: String = "1.0.4.2.3"
  val n1 = v1.padTo(v2.length, 0).toString.split('.').toList
  val n2 = v2.padTo(v1.length, 0).toString.split('.').toList


  def method(x1: List[String], x2: List[String]): Int = {
    @tailrec
    def loop(a: List[String], b: List[String]): Int = {

      if (a.head == b.head) {
        if (a.tail.isEmpty && b.head.isEmpty) loop(a.tail, b.tail)
        else 0
      }
      else if (a.head < b.head) -1
      else 1
    }
    loop(x1, x2)
  }
  println(method(n1, n2))
  val x1: String = n1.toString
  val y1: String = n2.toString
  val x2 = x1.replace(".", "")
  val y2 = y1.replace(".", "")
  val x3 = x2.mkString("")
  val y3 = y2.mkString("")
  if (x3 < y3) {
    println(-1)
  } else if (x3 == y3) {
    println(0)
  } else {
    println(1)
  }

  /*def compare(v1: String, v2: String): Int = {
    //    val head = v1.split('.').toList
    //    val tail = v2.split('.').toList

    @tailrec
    def loop(head: String, tail: String): Int = {
      if (head == "" && tail == "") 0
      else {
        if (head != "0") {
          loop(tail, tail)
        } else 1
      }
    }

    loop(v1, v2)
  }*/

//  println(v1.split('.').toList)
}