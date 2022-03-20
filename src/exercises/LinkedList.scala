package exercises

object LinkedList extends App {
  abstract class LogList {
    def last(): String = list.head

    def previous(): LogList = list.previous

    def isEmpty: Boolean = {
      if (list.head == Empty) true
      else false
    }

    def all: String = list.toString

    def add(msg: String): LogList = list.add(msg)

  }

  object Empty extends LogList {
    def add(msg: String): LogList = new Log(msg, Empty)
  }

  class Log(val head: String, val tail: String) extends LogList {
    def add(msg: String): LogList = new Log(msg, this)
  }

  val list = new Log("INFO_1", new Log("INFO_2", new Log("INFO_3", Empty)))

  println(list.all)
}
