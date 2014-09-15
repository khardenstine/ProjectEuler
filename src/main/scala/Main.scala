import euler.Problem
import scala.util.{Success, Failure, Try}

object Main {
	def main(args: Array[String]): Unit = {
		args.foreach{
      case "timings" => logTimings()
      case arg => {
        val message = reflect(arg) match {
          case Success(problem) => {
            val start = System.currentTimeMillis()
            val answer = problem.computeAnswer()
            val end = System.currentTimeMillis() - start
            s"$arg's answer is: $answer\nComputed in " + end / 1000 + "." + end % 1000 + " seconds"
          }
          case Failure(e) => e.getMessage + "\n\t" + e.getStackTrace.map(_.toString).mkString("\n\t")
        }
        System.out.println(message)
      }
		}
	}

	def reflect(problemNumber: String): Try[Problem] = Try {
		Class.forName("euler." + problemNumber).newInstance().asInstanceOf[Problem]
	}

  def logTimings() = {
    (1 to 500)
      .map(i => reflect("P%03d".format(i)))
      .flatMap {
        case Success(problem) => Some(problem)
        case Failure(e) => None
      }
      .foreach(p => {
        val start = System.currentTimeMillis()
        p.computeAnswer()
        val time: Long = System.currentTimeMillis() - start
        println(p.getClass.getName + ": " + time / 1000 + "." + time % 1000 + " seconds")
      })
  }
}
