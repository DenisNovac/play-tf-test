name := """play-scala-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

libraryDependencies += "org.typelevel" %% "cats-core"   % "2.6.1"
libraryDependencies += "org.typelevel" %% "cats-effect" % "2.1.3"


libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
libraryDependencies += "io.chrisdavenport" %% "log4cats-core"  % "1.1.1"
libraryDependencies += "io.chrisdavenport" %% "log4cats-slf4j" % "1.1.1"

// https://mvnrepository.com/artifact/org.scalatest/scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test

// https://mvnrepository.com/artifact/net.codingwell/scala-guice
libraryDependencies += "net.codingwell" %% "scala-guice" % "5.0.1"


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
