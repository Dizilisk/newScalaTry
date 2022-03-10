package lectures.week1basics

import scala.annotation.tailrec

object Recursion extends App {
  var i = 0
  while (i < 3) {
    println("Hello")
    i += 1
  }

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else {
      println(s"Имеем число $n , для которого считаем фаткориал ${n - 1}")
      val res = n * factorial(n - 1)
      println(s"Вычислим факториал $n")

      res
    }
  }

  factorial(3)

  def factorialWithTailRecursion(n: Int): Int = {
    @tailrec
    def loop(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else loop(x - 1, x * accumulator)
    }

    loop(n, 1)
  }
  println(factorialWithTailRecursion(5))

  def repeatWord(word: String, n: Int): String = {
    @tailrec
    def loop(i: Int, acc: String = word): String = {
      if (i <= 1) acc
      else loop(i - 1, s"$word $acc")
    }
    loop(n)
  }

  println(repeatWord("Hello", 3))

  def powerOfTwo(x: Int): BigInt = {
    @tailrec
    def power(i: Int, j: BigInt = 1, acc: BigInt = 2): BigInt = {
      if (i < 1) {
        j
      }
      else
        power(i - 1, j * acc)
    }
    power(x)
    }
  println(powerOfTwo(2))

  val x1 = 10
  val y1 = 1
  val n1 = 5
  def xyn(x1: Int, y1: Int, n1: Int): Int = {
    def loop(i: Int, j: Int, acc: Int): Int = {
      if (j < 1) {
        i
      }
      else {
        loop(i + acc, j - 1, i)
      }
    }
    loop(x1, y1, n1)
  }

  val a: String = xyn(x1, y1, n1).toString
  val b: Int = a.length
  val c: String = repeatWord(a, b)
  println(s"$c is the result")
}