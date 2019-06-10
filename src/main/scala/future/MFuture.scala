package future

import concurrent.ExecutionContext.Implicits.global
import concurrent.Future

object MFuture extends App {

  override def main(args: Array[String]): Unit = {

    def call(time: Long) = Future {
      val result = time + 10
      println(s"returning result $result")
      result
    }

    val result1 = call(10)
    val result2 = call(20)

    val total = for {
      r1 <- result1
      r2 <- result2
    } yield (r1 + r2)

    total.onComplete{
      case scala.util.Success(value) => println(s"success with value $value")
    }

    Thread.sleep(2000)

  }

}
