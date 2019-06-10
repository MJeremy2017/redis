package redis

import com.redis._

object Connector {

  def main(args: Array[String]): Unit = {

    val r = new RedisClient("localhost", 6379)

    // string
    r.set("name", "jeremy")

    println(r.get("name"))

    // list
    r.lpush("list-1", "foo")
    r.rpush("list-1", "bar")

    // hash
    r.hmset("hash", Map("f1" -> "1", "f2" -> 2))
    val hashAll = r.hgetall1("hash")
    println(hashAll)

    println(r.hmget[String, String]("hash", "f1", "f2"))  // Some(Map(f1: 1, f2: 2))

    /*
    * scala-redis is a blocking client,
    * which serves the purpose in most of the cases since Redis is also single threaded.
    * But there may be situations when clients need to manage multiple
    * RedisClients to ensure thread-safe programming.
    * */

    // pooling
    val clients = new RedisClientPool("localhost", 6379)

    def lp(msgs: List[String]) = {
      clients.withClient(
        client => {
          msgs.foreach(client.lpush("list-l", _))
          client.llen("list-l")
        }
      )
    }

    val msgs = List("a", "b", "c")

    lp(msgs)

  }

}
