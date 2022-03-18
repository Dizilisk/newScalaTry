package lectures.week2oop

object Exceptions extends App {

  /* Errors
  * StackOverflowError - оишбка cheap памяти, выделяемая для методов
  * OutOfMemoryError - ошибка памяти heap, выделяемая для объектов */

  /* Exceptions
  * NullPointerException - возникает, если попытаться дполучить доступ к тому, чего нет */

  val x: String = null
  println(x.length)

  /* RuntimeException
  * Бросается, когда необходимо указать на какие-то логические ошибки программы */

  throw new NullPointerException //способ вызвать сброс исключения

  def IntOrNothing(hasException: Boolean): Int = {
    if (hasException) throw new RuntimeException("Exception is here")
    else 200
  }

  try {
    IntOrNothing(true)
  }
  catch {
    case e: RuntimeException => println("RTE is here")
  }
  finally {
    println("I will be there no matter what")
  }

  class MyException extends Exception
  val exception = new MyException
  throw exception

  val exceptionVal = throw new NullPointerException //тип Nothing
  val potentialException = try { //тип Any
    IntOrNothing(false)
  } catch {
    case e: RuntimeException => println("RET is here")
  } finally {
    println("I will be there no matter what")
  }

}
