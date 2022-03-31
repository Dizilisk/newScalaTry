package lectures.week3fp

import scala.annotation.tailrec

object FunctionsFP extends App {
  trait Multiplication[A, B] {
    def apply(x: A): B
  }
  val res = new Multiplication[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }

  println(res(2))

  val res1 = new Function[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }

  val product = new ((Int, Int) => Int) {
    override def apply(x: Int, y: Int): Int = x * y
  }

  println(product(3, 4))

  val strlen = (x: String) => x.length
  println(strlen("Hello, world!"))
    @tailrec
  def nTimes(f: Int => Int, x: Int, n: Int): Int = {
    if (n <= 0) x
    else nTimes(f, f(x), n - 1)
  }

  val increment = (x: Int) => x + 1

  println(nTimes(increment, 0, 3))

  def add(x: Int)(y: Int) = x + y

  println(add(1)(2))

  def curryingNTimes(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x
  else (x: Int) => curryingNTimes(f, n - 1)(f(x))
  }

  println(curryingNTimes(increment, 1)(0))

  def someFunc: Int => ((Int) => Int) = new ((Int) => ((Int) => Int)) {
    override def apply(x: Int): (Int) => Int = new ((Int) => Int) {
      override def apply(y: Int): Int = x + y
    }
  }

  val res3 = someFunc(1)
  println(res3)

  /* Частичные функции */

  val whatToDo = (d: String) => d match {
    case "mon" => "Work!"
    case "fri" => "Party time"
    case "sun" => "Relax a little"
  }

  val aPartialFunction: PartialFunction[String, String] = {
    case "mon" => "Work!"
    case "fri" => "Party time"
    case "sun" => "Relax a little"
  }

  val pfChain: PartialFunction[String, String] = aPartialFunction.orElse[String, String] {
    case "sat" => "It's just Saturday"
  }

  val lifted = aPartialFunction.lift

  println(aPartialFunction("sun"))
//  println(aPartialFunction("sat")) // Match error
  println(aPartialFunction.isDefinedAt("tue"))
  println(pfChain("mon"))
  println(pfChain("sat"))
  println(lifted("fri"))
  println(lifted("thu"))

  val chat: PartialFunction[String, String] = {
    case "hello" => "Hi, I'm Bot"
    case "bye" => "Bye-bye"
    case "what's up" => "sup-sup"
  }

  val chatbot = chat.lift

  println(chatbot("hello"))
  println(chatbot("bye"))
  println(chatbot("what's up"))
  println(chatbot("none"))

  scala.io.Source.stdin.getLines().foreach(line => println(chatbot(line)))
  scala.io.Source.stdin.getLines().map(chatbot).foreach(println)
}
