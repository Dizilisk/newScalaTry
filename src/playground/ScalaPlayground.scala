package playground

import scala.util.{Failure, Success, Try}

object ScalaPlayground {
    def main(args: Array[String]): Unit = {
        println("hello world!")
    }

    object HttpService {
        def apply(s1: String, s2: String): Try[Connection] = ???
    }
    class Connection {
        def get(url: String): String = ""
    }
    val host: String = "host"
    val port: String = "port"
    def fail1(): String = throw new Exception("Your Connection was Interrupted")
    def fail2(): String = throw new Exception("Someone else took the port")

    def render(page: Any): Unit = ???

    val page: Any = ???

    def safeConnection(host: String, port: String): Try[Connection] = Try(HttpService(host, port))

    def safeUrl(url: String): Try[String] = Try(url)

    for {
        r1 <- safeConnection(host, port)
        r2 <- safeUrl(r1.get("url"))
    } yield render(r1.get(r2))

}