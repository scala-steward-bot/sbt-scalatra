addSbtPlugin("org.scalariform" % "sbt-scalariform"      % "1.8.3")
addSbtPlugin("com.github.sbt"    % "sbt-pgp"              % "2.3.1")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

// scripted for plugin testing
libraryDependencies += { "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value }
