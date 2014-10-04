package euler

class P027 extends Problem {
  def computeAnswer() = {
    for (
      a <- -999 to 999;
      b <- CommonFunctions.Primes.takeWhile(_ <= 999)
    ) yield (a * b, P027.consecutivePrimes(a, b))
  }.maxBy(_._2)._1.toString
}

object P027 {
  /**
   * n² + an + b
   */
  def consecutivePrimes(a: Int, b: Int): Int = {
    Stream.from(0)
      .map(n => (n * n) + (a * n) + b)
      .takeWhile(isPrime)
      .size
  }

  private def isPrime(n: Int): Boolean = CommonFunctions.Primes.takeWhile(_ <= n).lastOption.exists(_ == n)
}
