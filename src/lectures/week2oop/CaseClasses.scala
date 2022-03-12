package lectures.week2oop

object CaseClasses extends App {
  val student = new Student(0, "Bob")
  println(student.name)
  student.uni
}

class Student(id: Int, val name: String) {
  val uni = "University"
  println("Student class")
}