organization := "org.scalatra"
name := "sbt-scalatra-dist-test"
version := "0.1.0-SNAPSHOT"
scalaVersion := sys.props("scala_version")
scalacOptions ++= {
  scalaBinaryVersion.value match {
    case "3" =>
      Nil
    case _ =>
      Seq("-Xsource:3")
  }
}

Test / fork := true

val ScalatraVersion = sys.props("scalatra_version")

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra-jakarta" % ScalatraVersion,
  "org.scalatra" %% "scalatra-specs2-jakarta" % ScalatraVersion % "test"
)

enablePlugins(DistPlugin)

lazy val checkDist = taskKey[Unit]("check if the distribution exists")

checkDist := Def.uncached {
  val zipFile =
    (Compile / target).value / s"${name.value}-${version.value}.zip"
  if (!zipFile.isFile) sys.error("distribution not found: " + zipFile)
}
