package lectures.week2oop

object ClassesOOP extends App {
  val student = new Student(0, "Bob")
  println(student.name)
//  student.uni

  class Student(id: Int, val name: String) {
    val uni = "University"
    println("Student class")
    def getID(name: String, id: Int): String = s"$name has ID $id and $name has ID $id"
  }

  val student1 = new Student(1, "Sam")
  println(student.getID("Pam", 2))

  class Student1(id: Int, val name: String) {
    def getID(name: String, id: Int): String = s"${this.name} has ID ${this.id} and $name has Id $id"

    def getID: String = s"here is $name's and ID $id"
  }

  val student2 = new Student1(1, "Sam")
  println(student2.getID("Pam", 2))
  println(student2.getID)

  class Student2(id: Int, val name: String) {
    def this(name: String) = this(0, name)
    def this() = this(0, "NoName")
  }

  val noStudent = new Student2()
  val newStudent = new Student2("Will")
  val student4 = new Student2(1, "Sam")

  class Student3(id: Int = 0, val name: String)

  val student5 = new Student3(1, "Sam")
  val newStudent2 = new Student3(name = "Will")

  class Employee(val name: String, var salary: Double) {
    def this() = this("John", 0.0)
  }

  val employee = new Employee()
  println(s"${employee.name}'s salary is ${employee.salary}")

  val instructor1 = new Instructor(1, "john", "sina")
  val instructor2 = new Instructor(2, "vova", "vist")
  val course = new Course(3, "kurs", "1", instructor1)
  val course1 = new Course(5, "kurs1", "15", instructor2)

  class Instructor(val id: Int, name: String, surname: String) {
    val checkName: String = (name.toLowerCase.take(1).toUpperCase) ++ (name.toLowerCase.substring(1, name.length))
    val checkSurname: String = (surname.toLowerCase.take(1).toUpperCase) ++ (surname.toLowerCase.substring(1, surname.length))
    def fullName(): String = {
      checkName ++ " " ++ checkSurname
    }
  }
  class Course(courseID: Int, title: String, var releaseYear: String, instructor: Instructor) {
    def getID: Int = {
     (courseID.toString ++: instructor.id.toString).toInt
    }
    def isTaughtBy(instructor: Instructor): Boolean = {
      if (getID.toString.drop(1).toInt == instructor.id) true
      else false
    }
  def copyCourse(newReleaseYear: String): Course = {
    val releaseDate: Course = new Course(courseID, title, releaseYear = newReleaseYear, instructor)
    releaseDate
    }
  }
  println(course.getID)
  println(course1.getID)
  println(course.isTaughtBy(instructor1))
  println(course1.isTaughtBy(instructor1))

  val x = "sCALA"
  val y = x.capitalize
  println(y)
}