package euler

class P002 extends Problem {
  def computeAnswer() = {
    P002.buildFibonacciItr(4000000)
      .filter(_ % 2 == 0)
      .sum
      .toString()
  }
}

object P002 {
  def buildFibonacciItr(maxValue: Int): Iterator[BigInt] = {
    CommonFunctions.Fibonacci.drop(2).takeWhile(_ <= BigInt(maxValue)).iterator
  }
}
