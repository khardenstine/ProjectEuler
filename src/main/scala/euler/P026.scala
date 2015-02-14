package euler

import P026._
import scala.collection.mutable.ArrayBuffer

class P026 extends Problem {
  def computeAnswer() = {
    getLargestRecurringCycleLessThan(1000)(DEFAULT_THRESHOLD)
  }
}

object P026 {
  final val DEFAULT_THRESHOLD = Threshold(10000, 10)

  def getLargestRecurringCycleLessThan(d: Int)(implicit threshold: Threshold): Int = {
    case class FractionCycle(d: Int, cycle: String) extends Ordered[FractionCycle] {
      def compare(that: FractionCycle): Int = this.cycle.length.compare(that.cycle.length)
    }

    (2 to d)
      .par
      .flatMap(i => getUnitFractionRecurringCycle(i).map(FractionCycle(i, _)))
      .max.d
  }

  def getUnitFractionRecurringCycle(d: Int)(implicit threshold: Threshold): Option[String] = {
    assert(d > 1)

    var digits = ArrayBuffer[Int]()

    var dividend = 10
    while (dividend != 0 && digits.size < threshold.length) {
      digits += dividend / d
      dividend = dividend % d * 10
    }

    getCycle(digits)
  }

  def getCycle(digits: Seq[Int])(implicit threshold: Threshold): Option[String] = {
    if (digits.size < threshold.length) {
      None
    } else {
      val cycles = for (
        startIdx <- (0 to threshold.length - threshold.repetitions).iterator;
        cycleLength <- (1 to ((threshold.length - startIdx) / threshold.repetitions)).iterator
      ) yield Cycle(startIdx, cycleLength, digits, threshold)

      cycles.find(_.isValid).map(_.toString)
    }
  }

  case class Cycle(start: Int, length: Int, digits: Seq[Int], threshold: Threshold) {
    val slice = digits.slice(start, start + length)

    def isValid: Boolean = {
      var valid = true
      var count = 0

      var nextStart = start + length

      while (valid && nextStart < digits.size && count < threshold.repetitions) {
        val nextSlice = digits.slice(nextStart, nextStart + length)
        val compareSlice = if (nextSlice.size == slice.size) slice else slice.take(nextSlice.size)
        if (compareSlice != nextSlice) {
          valid = false
        }
        count += 1
        nextStart = nextStart + length
      }
      valid
    }

    override def toString: String = slice.mkString
  }

  /**
   *
   * @param length number of non-patterned digits to digest before qualifying as irrational
   * @param repetitions minimum number of repetitions to find before qualifying as cyclic
   */
  case class Threshold(length: Int, repetitions: Int) {
    assert(length > 0 && repetitions > 0)
  }
}
