name := """fileupload"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
libraryDependencies += ws
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.github.aselab" %% "scala-activerecord" % "0.3.2",
  "com.github.aselab" %% "scala-activerecord-play2" % "0.3.2"
)
libraryDependencies += "commons-io" % "commons-io" % "2.5"


resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
