package lectures.week3fp

import scala.util.{Try, Success, Failure}

object ExceptionsFP extends App {
  def unsafeMethod(): String = throw new RuntimeException("Sorry, not your day")
  def myMethod(): String = "My method is valid"
  def methodWithFails(): Try[String] = Failure(new RuntimeException("Ooops...."))
  def methodWithSucceeds(): Try[String] = Success("Everything is OK")

  val potentialFailure = Try(unsafeMethod())
  val anotherPotentialFailure = Try {
    //Код исключения
  }
  val executeWithTry = Try(unsafeMethod()).orElse(Try(myMethod()))
  val tryMethods = methodWithFails() orElse methodWithSucceeds()

  println(potentialFailure)
  println(potentialFailure.isSuccess)
  println(executeWithTry)
  println(tryMethods)
}
