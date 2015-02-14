package euler

class P035 extends Problem {
  def computeAnswer() = {
    P035.countCircularPrimesBelow(1000000)
  }
}

object P035 {
  def countCircularPrimesBelow(i: Int): Int = {
    // this could be more efficient in cases like i = (10^ANY) + 1
    val maxUsedPrime = (i - 1).toString.map(_ => '9').toInt
    val relevantPrimes = CommonFunctions.Primes.takeWhile(_ <= maxUsedPrime).toSet

    relevantPrimes.count(isCircularPrime(_, relevantPrimes))
  }

  def isCircularPrime(num: Int, primes: Set[Int]): Boolean = {
    getAllRotations(num).forall(primes.contains)
  }

  def getAllRotations(num: Int): Set[Int] = {
    val digits = CommonFunctions.getReverseDigitsIterator(num).toList
    val digitRange = 0 until digits.size
    digitRange.map { startIdx =>
      digitRange.zipWithIndex.map { zipd =>
        val digit = digits((startIdx + zipd._2) % digits.size)
        digit * Math.pow(10, zipd._1).toInt
      }.sum
    }.toSet
  }
}
