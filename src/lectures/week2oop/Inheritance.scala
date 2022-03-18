package lectures.week2oop

import org.w3c.dom.events.Event

import java.awt.Button
import java.net.http.WebSocket.Listener

object Inheritance  extends App {
  class Person {
    def greet: String = "Hello" //private, protected

  }

  class Student extends Person {
    println(greet) //ошибка, если private
  }

  val student = new Student
  println(student.greet) //ошибка, если private или protected

  class Person1(name: String, age: Int) {
    def greet: String = s"Hello"

    def this() = this("UnknownPerson", 0)
  }

  class Student1(name: String, age: Int, id: Int) extends Person1(name, age) {
    println(greet)
  }

  class Person2(name: String, age: Int) {
    val gender = "n/a"

    def greet: String = s"Hello"

    def this() = this("UnknownPerson", 0)

  }

  class Student2(name: String, age: Int, id: Int, studGender: String) extends Person2 {
    override val gender: String = studGender

    override def greet: String = s"${super.greet}, $name"
  }

  val student1 = new Student2("James", 24, 1, "m")
  println(student1.greet)
  println(student1.gender)

  val aPerson: Person2 = new Student2("Alice", 24, 2, "f")
  println(aPerson.greet)

  class Button(label: String) {
    def label1: String = s"$label"

    def click(): String = s"button -$label1- has been clicked"

    def this() = this("test")
  }

  class RoundedButton(label: String) extends Button(label) {
    override def label1: String = super.label1

    override def click(): String = s"rounded button -${super.label1}- has been clicked"
  }

  class TestButton extends Button {
    override def click(): String = s"test ${super.click()}"
  }

  val button = new TestButton()
  println(button.click())

  sealed abstract class DayOfTheWeek(val name: String, val isWeekend: Boolean)

  case object Monday extends DayOfTheWeek("Monday", false)

  case object Tuesday extends DayOfTheWeek("Tuesday", false)

  case object Wednesday extends DayOfTheWeek("Wednesday", false)

  case object Thursday extends DayOfTheWeek("Thursday", false)

  case object Friday extends DayOfTheWeek("Friday", false)

  case object Saturday extends DayOfTheWeek("Saturday", true)

  case object Sunday extends DayOfTheWeek("Sunday", true)

  abstract class BaseDataSource(dataSourceName: String) {
    def save: String = {
      s"Save method implemented"
    }

    def delete: String = {
      s"Delete method implemented"
    }

    val user: String

    def connect: String
  }

  class PublicDataSource(ds: String) extends BaseDataSource(ds) {
    val user = "publicUser"

    override def connect: String = {
      s"Public Data Source, no password needed" //override можно опустить
    }
  }

  val someSource = new BaseDataSource("someDS") {
    override val user: String = "SomeSourceUser"

    override def connect: String = "someSource connection"
  }

  println(someSource.save)

  abstract class Event {
    def trigger(eventName: String): Unit
  }

  class Listener(val eventName: String, var event: Event) {
    def register(evt: Event) {
      event = evt
    }
    def sendNotification() {
      event.trigger(eventName)
    }
  }

  val notification: Listener = new Listener("mousedown", null)

  notification.register(new Event {
    override def trigger(eventName: String): Unit = println(s"trigger $eventName event")
  })

  notification.sendNotification()
  println(notification.event.trigger(s"trigger ${notification.eventName} event"))

  trait PublicConn {
    def showNotification: String

  }

trait PrivateConn {
  def checkCredentials: Boolean
}

  class SomeDataSource(ds: String) extends BaseDataSource(ds) with PublicConn with PrivateConn {
    val user = "Public User"

    def connect: String = {
      s"Public Data source, no password needed"
    }

    override def checkCredentials: Boolean = true

    override def showNotification: String = s"This connection is public"
  }

}