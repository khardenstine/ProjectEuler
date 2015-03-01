package euler

import P046._

class P046 extends Problem {
  def computeAnswer() = {
    CommonFunctions.CompositeNumbers
      .filter(_ % 2 != 0)
      .find(!sumOfPrimeAndDoubleSquare(_))
      .get
  }
}

object P046 {
  lazy val DoubleSquares = Stream.from(1).map(i => 2 * Math.pow(i, 2).toInt)

  def sumOfPrimeAndDoubleSquare(n: Int): Boolean = {
    CommonFunctions.Primes
      .takeWhile(_ < n + DoubleSquares.head)
      .map(n - _)
      .exists(
        possibleDoubleSquare =>
          DoubleSquares.find(_ >= possibleDoubleSquare).get == possibleDoubleSquare
      )
  }
}
