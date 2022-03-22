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
}
