package exercises

import scala.annotation.tailrec

object GenericList extends App {
  abstract class LogList[Any] {
    def last: String

    def previous: LogList[AnyRef]

    def isEmpty: Boolean

    def all: String

    def add[String >: Int](msg: String): LogList[AnyRef]
  }

  object Empty extends LogList[AnyRef] {
    override def last: String = throw new NoSuchElementException

    override def previous: LogList[AnyRef] = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def all: String = ""

    override def add[AnyRef >: Int](msg: String): LogList[AnyRef] = new Log(msg, Empty)
  }

  class Log[Any](val head: String , val tail: LogList[AnyRef]) extends LogList[AnyRef] {
    override def last: String = head

    override def previous: LogList[AnyRef] = tail

    override def isEmpty: Boolean = false

    override def all: String = {
      @tailrec
      def loop(Empty: LogList[AnyRef], acc: String): String = {
        if (Empty.isEmpty) acc
        else {
          loop(Empty = Empty.previous,
            s"$acc " ++ Empty.last)
        }
      }
      loop(tail, head)
    }

    override def add[AnyRef >: Int](msg: String): LogList[AnyRef] = new Log(msg, this)
  }
}
