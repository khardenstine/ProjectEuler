package euler

import scala.collection.mutable.ArrayBuffer

class P037 extends Problem {
  def computeAnswer() = {
    val truncatablePrimes = new ArrayBuffer[Int](11)
    CommonFunctions.Primes.takeWhile { prime =>
      if (prime > 10 && P037.isTruncatable(prime)) {
        truncatablePrimes += prime
      }
      truncatablePrimes.size < 11
    }.toList

    truncatablePrimes.sum
  }
}

object P037 {
  def isTruncatable(i: Int): Boolean = {
    truncations(i).forall(isPrime)
  }

  def truncations(i: Int): Traversable[Int] = {
    val iStr = i.toString
    (0 until iStr.size)
      .view
      .map(iStr.splitAt)
      .map(tup => Seq(tup._1, tup._2))
      .flatten
      .filter(_ != "")
      .map(_.toInt)
  }

  def isPrime(i: Int): Boolean = {
    CommonFunctions.Primes.find(_ >= i).get == i
  }
}
