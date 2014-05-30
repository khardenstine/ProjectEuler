import euler.Problem
import scala.util.{Success, Failure, Try}

object Main {
	def main(args: Array[String]): Unit = {
		args.foreach{ arg =>
			val message = reflect(arg) match {
				case Success(problem) => s"$arg's answer is: " + problem.computeAnswer()
				case Failure(e) => e.getMessage + "\n\t" + e.getStackTrace.map(_.toString).mkString("\n\t")
			}
			System.out.println(message)
		}
	}

	def reflect(problemNumber: String): Try[Problem] = Try {
		Class.forName("euler." + problemNumber).newInstance().asInstanceOf[Problem]
	}
}
