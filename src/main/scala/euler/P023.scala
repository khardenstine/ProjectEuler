package euler

class P023 extends Problem {
  def computeAnswer() = {
    (1 to 28123)
      .filterNot(P023.isSumOf2AbundantNumbers)
      .sum
  }
}

object P023 {
  lazy val abundantNumbersLessThan28123: collection.SortedSet[Int] = {
    val set = collection.mutable.SortedSet[Int]()
    set.++((1 to 28123).filter(isAbundant))
  }

  def isSumOf2AbundantNumbers(n: Int): Boolean = {
    abundantNumbersLessThan28123
      .view
      .takeWhile(_ <= n / 2)
      .exists(i => abundantNumbersLessThan28123.contains(n - i))
  }

  def sumOfFactors(n: Int) = CommonFunctions.getFactors(n).sum + 1
  def isAbundant(n: Int) = sumOfFactors(n) > n
  def isPerfect(n: Int) = sumOfFactors(n) == n
  def isDeficient(n: Int) = sumOfFactors(n) < n
}
