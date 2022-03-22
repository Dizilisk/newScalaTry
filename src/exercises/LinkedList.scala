package exercises

import scala.annotation.tailrec

object LinkedList extends App {
  abstract class LogList {
    def last: String

    def previous: LogList

    def isEmpty: Boolean

    def all: String

    def add(msg: String): LogList
  }

  object Empty extends LogList {
    override def last: String = throw new NoSuchElementException

    override def previous: LogList = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def all: String = ""

    override def add(msg: String): LogList = new Log(msg, Empty)
  }

  class Log(val head: String, val tail: LogList) extends LogList {
    override def last: String = head

    override def previous: LogList = tail

    override def isEmpty: Boolean = false

    override def all: String = {
      @tailrec
      def loop(Empty: LogList, acc: String): String = {
        if (Empty.isEmpty) acc
        else {
          loop(Empty = Empty.previous,
            s"$acc " ++ Empty.last)
        }
      }
      loop(tail, head)
    }

    override def add(msg: String): LogList = new Log(msg, this)
  }

  val list = new Log("m3", new Log("m2", new Log("m1", Empty)))
  val list1 = list.add("m4")
  val list2 = list1.add("m5")

  print(list2.all)
}
