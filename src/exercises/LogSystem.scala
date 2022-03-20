package exercises

import scala.annotation.tailrec

object LogSystem extends App {

  class Logger(var msgNum: Int = 0) {

    def info(): Logger = {
      println("INFO New Message")
      new Logger(msgNum + 1)
    }

    def info(n: Int): Logger = {
      if (n < 1) this
      else {
        info.info(n - 1)
      }
    }

    def print: Unit = println(msgNum)
  }

  val logger = new Logger(0)
  logger.info.print
  logger.info(3).print
  logger.info.info.info.print
}