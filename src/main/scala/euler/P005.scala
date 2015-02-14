package euler

class P005 extends Problem {
  def computeAnswer() = {
    P005.getSmallestDividend(1 to 20)
  }
}

object P005 {
  def getSmallestDividend(divisors: Iterable[Int]): Int = {
    val maxDivisor = divisors.max

    def getSmallestDividend(dividend: Int, divisors: Iterable[Int]): Int = {
      if (isMultipleOfAll(dividend, divisors)) {
        dividend
      } else {
        getSmallestDividend(dividend + maxDivisor, divisors)
      }
    }

    getSmallestDividend(maxDivisor, divisors)
  }

  def isMultipleOfAll(dividend: Int, divisors: Iterable[Int]): Boolean = {
    divisors.forall(dividend % _ == 0)
  }
}
