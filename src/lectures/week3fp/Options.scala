package lectures.week3fp

object Options extends App {
  def unsafeMethod(): Option[String] = None
  def safeMethod(): String = "There is a String"
  def maybeSafeMethod(): Option[String] = Some("There is no harm")

  val unsafeRed = Option(unsafeMethod())
  val safeRes = Option(safeMethod())

  println(unsafeRed)
  println(safeRes)

  val someOptions: Option[String] = Some("Success")
  val noneOptions: Option[Int] = None

  println(someOptions.isEmpty)
  println(noneOptions.isEmpty)

  val chainedResult = unsafeMethod() orElse maybeSafeMethod()
  println(chainedResult)
}