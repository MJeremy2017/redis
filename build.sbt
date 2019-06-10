name := "redis"

version := "0.1"

scalaVersion := "2.12.0"

libraryDependencies ++= Seq(
  "net.debasishg" %% "redisclient" % "3.9",
  "org.slf4j"  % "slf4j-api" % "1.7.5",
  "org.slf4j"  % "slf4j-simple" % "1.6.4"
)

resolvers += "redisclient" at "https://mvnrepository.com/artifact/net.debasishg"