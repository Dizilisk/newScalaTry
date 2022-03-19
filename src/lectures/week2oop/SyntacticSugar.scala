package lectures.week2oop

import scala.language.postfixOps

object SyntacticSugar extends App {
  class Person(val name: String, occupation: String) {
    def workAs(jobName: String): Boolean = jobName == occupation

    def speaksEnglish: Boolean = true

    def &(person: Person): String = s"${this.name} and ${person.name} are colleagues"

    def unary_! : String = s"$name is not real"

    def apply(): String = s"$name works as a $occupation"

  }

  val bob = new Person("Bob", "Developer")
  val alice = new Person("Alice", "Data engineer")
  println(bob.workAs("Developer"))
  println(bob workAs "Developer")
  println(bob.speaksEnglish)
  println(bob speaksEnglish)

  println(1 + 2)
  println(1. + (2))

  println(bob.&(alice))
  println(bob & alice)

  val x = -1.unary_- //unary_ только для + - ~ !

  println(!bob)
  println(bob.unary_!)
  println(bob unary_!)

  println(bob.apply())
  println(bob())


  class Person1(val name: String) {
    def unary_+ : Person1 = new Person1(s"$name NoSurname")
  }

  val person = new Person1("Bob")
  println((+person).name)
}
