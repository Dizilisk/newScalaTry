package lectures.week1basics

object Functions extends App {
    def aPerson(name: String, surname: String): Unit = {
      println(s"$name $surname")
    }
  aPerson("John", "Smith")

  def aParameterlessFunction(): Unit = println("Function with no parameters")
  aParameterlessFunction()
  aParameterlessFunction

  def aFunctinWithDefaultParameter(x: Int, y: String = "Default parameter"): String = {
    s"x = $x and y = $y"
  }
  println(aFunctinWithDefaultParameter(1))

  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }
  def callByName(x: => Long): Unit = {
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }
  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def someFunc(): Int = 2 * someFunc() + 1
  def callSomeFunc(x: Int, y: => Int) = println(x)
  callSomeFunc(1, someFunc())

  def aBossFunction(): String = {
    def aHelperFunction(): String = "I'm here to help"
  aHelperFunction()
  }


}