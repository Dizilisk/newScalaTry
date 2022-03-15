package lectures.week2oop

object ObjectsOOP extends App {
  val numA = new Number
  val numB = new Number

  object Number {
    val Pi = 3.14
    println(numA == numB)
  }

  println(Number.Pi)

  class Number {
    println(numA == numB)
  }

  class MyString(val str: String) {
    private var extra = "extraData"

    override def toString: String = str + extra
  }

  object MyString {
    def apply(base: String, extras: String): MyString = {
      val s = new MyString(base)
      s.extra = extras
      s
    }

    def apply(base: String) = new MyString(base)
  }

  println(MyString("Hello", "world"))
  println(MyString("welcome"))

  class Number1(val num: Int)

  object Number1 {
    val Pi = 3.14

    def apply(x: Number1, y: Number1): Number1 = new Number1(x.num + y.num)
  }

  val numA1 = new Number1(1)
  val numB1 = new Number1(2)
  val numC1 = Number1(numA1, numB1)
  println(numA1.num)
  println(numB1.num)
  println(numC1.num)

  class PersonalAccount

  class BusinessAccount

  class Branch {
    def openAccount(accountType: String): Object = {
      Account(accountType)
    }
  }

  object Account {
def apply(accountType: String): Object = {
  if (accountType == "business") new BusinessAccount
  else new PersonalAccount
}
  }

  val branch = new Branch()
  val account = branch.openAccount("business")
}
