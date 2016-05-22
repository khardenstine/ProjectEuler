name := "ProjectEuler"
version := "1.0"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
    "org.scalatest"   %% "scalatest"    % "2.1.6"   % "test,it",
    "org.scalacheck"  %% "scalacheck"   % "1.11.4"      % "test,it"
)

scalacOptions ++= List("-feature","-deprecation", "-unchecked", "-Xlint")

scalariformSettings

// ScalaTest settings.
// Ignore tests tagged as @Slow (they should be picked only by integration test)
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-l", "org.scalatest.tags.Slow", "-u","target/junit-xml-reports", "-oD", "-eS")
