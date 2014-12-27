package euler

class P006 extends Problem {
  def computeAnswer() = {
    Math.abs(P006.getSumOfSquares(1 to 100) - P006.getSquareOfSum(1 to 100)).toString
  }
}

object P006 {
  def getSumOfSquares(numbers: Iterable[Int]): Int = {
    numbers.map(Math.pow(_, 2).toInt).sum
  }

  def getSquareOfSum(numbers: Iterable[Int]): Int = {
    Math.pow(numbers.sum, 2).toInt
  }
}
