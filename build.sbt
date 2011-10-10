organization := "sc.ala"

name := "scalerity"

version := "0.0.1"

scalaVersion := "2.9.1"

retrieveManaged := true

testFrameworks += new TestFramework("org.specs2.runner.SpecsFramework")

libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _ )

libraryDependencies += "org.scalatest" %% "scalatest" % "1.6.1" % "test"

libraryDependencies += "be.roam" % "hue" % "1.1" from "http://repo1.maven.org/maven2/be/roam/hue/hue/1.1/hue-1.1.jar"

libraryDependencies ++= Seq(
  "commons-io" % "commons-io" % "2.0",
  "org.specs2" %% "specs2" % "1.6-SNAPSHOT" % "test"
)

resolvers += ScalaToolsSnapshots

