import java.io.FileWriter

import sbt._
import Keys._
import sbt.complete.DefaultParsers.IntBasic
import sbt.complete.Parsers._

/**
 * Additional configuration
 */ 
object Build extends Build {

  def generateProblemClass(problemNumber: Int) = {
    val paddedNumber = "%03d".format(problemNumber)

    println(s"Generating Problem class and companion object for problem $problemNumber")

    val sourceFile = new File(s"src/main/scala/euler/P$paddedNumber.scala")
    if (sourceFile.exists())
      sys.error(s"Source already generated for problem $problemNumber")

    val fw = new FileWriter(sourceFile)
    fw.write(s"""package euler
                |
                |import P$paddedNumber._
                |
                |class P$paddedNumber extends Problem {
                |  def computeAnswer() = {
                |    ""
                |  }
                |}
                |
                |object P$paddedNumber {
                |
                |}
                |""".stripMargin)
    fw.close()
  }

  def generateTestSuite(problemNumber: Int) = {
    val paddedNumber = "%03d".format(problemNumber)

    println(s"Generating Test Suite for problem $problemNumber")
    val testFile = new File(s"src/test/scala/euler/T$paddedNumber.scala")
    if (testFile.exists())
      sys.error(s"Test Suite already generated for problem $problemNumber")

    val fw = new FileWriter(testFile)
    fw.write(s"""package euler
                |
                |import P$paddedNumber._
                |import org.scalatest.FunSuite
                |
                |class T$paddedNumber extends FunSuite {
                |
                |}
                |""".stripMargin)
    fw.close()
  }

  val generate = inputKey[Unit](
    "Generates an empty Problem class, companion object, and test suite for a problem number"
  ) := {
    spaceDelimited("<problem number>")
      .parsed
      .map(_.toInt)
      .foreach {
        n =>
          generateProblemClass(n)
          generateTestSuite(n)
      }
  }
 
  lazy val integrationTest =
    Project("root", file("."), settings = settings ++ Seq(generate))
      .configs( IntegrationTest )
        .settings( Defaults.itSettings : _* )
      	.settings(
          scalaSource in IntegrationTest <<= baseDirectory / "src/test/scala",
      	  resourceDirectory in IntegrationTest <<= baseDirectory / "src/test/resources",
      	  parallelExecution in IntegrationTest := false,
          testOptions in IntegrationTest += Tests.Argument(TestFrameworks.ScalaTest, "-n", "org.scalatest.tags.Slow"))

}
