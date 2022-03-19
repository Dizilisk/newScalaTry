package lectures.week2oop

import lectures.week2oop.ClassesOOP.{Instructor, course}

object CaseClasses extends App {
  case class Person(name: String, occupation: String)

  val bob = new Person("Bob", "Developer")
  val bobsDouble = new Person("Bob", "Developer")
  val anotherBob = bob.copy()
  val bobsTwin = bob.copy("John")
  val alice = Person("Alice", "Engineer")
  println(bob.name) //доступ к name без val
  println(bob.toString)
  println(bob == bobsDouble)
  println(anotherBob)
  println(bobsTwin)
  println(alice)

  case class Course(title: String, instructor: String)

  object Course {
    def apply(instructor: String): Course = Course("AdvancedScala", instructor)
  }

  val scalaCourse = new Course("Scala", "Bob")

  val course = new Course("Scala", "Bob")
  println(course)
}