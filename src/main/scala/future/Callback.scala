package future

import scala.concurrent.{Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import scala.util.Random


object Callback extends App {

  def sleep(time: Long) { Thread.sleep(time) }

  val f = Future {
    sleep(Random.nextInt(500))
    42
  }

  println("before onComplete")

  f.onComplete {
    case Success(value) => println(s"call back, value $value")
    case Failure(e) => e.printStackTrace()
  }

  println("A ..."); sleep(100)
  println("B ..."); sleep(100)
  println("C ..."); sleep(100)
  println("D ..."); sleep(100)

  // the output from this code is nondeterministic

  sleep(1000)

}
