/**
  * You want a simple way to run one or more tasks concurrently in a Scala application,
  * including a way to handle their results when the tasks finish.
  * For instance, you may want to make several web service calls in parallel,
  * and then work with their results after they all return.
  *
  * Computation of your algorithm starts at some nondeterministic time
  * after the future is created, running on a thread assigned to it by the execution context.
  */

package future

import concurrent.{Await, Future}
import concurrent.duration._
import concurrent.ExecutionContext.Implicits.global


object Futures1 extends App {

  def sleep(time: Long) { Thread.sleep(time) }

  val f = Future {
    sleep(500)
    1+1
  }

  // this is blocking (blocking is bad)
  val result = Await.result(f, 1 seconds)

  println(result)

}
