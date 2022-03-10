package lectures.week1basics

object Expressions extends App {
  val aVal = 1 + 2 * 3
  println(1 + 2 * 3)

  val aCondition = true
  val ifExpressionsValue = if (aCondition) "True Condition" else "False Condition"
  println(ifExpressionsValue)

  val someVal: Unit = println("I just want to print")

  /*val aNumber = if ("string".length == 6 & 1 < 2)
    &
  ('1' +: "23" :+ '4').toInt == 1234
  24
  else
  1234
  }*/
}
