package euler

class P034 extends Problem {
  def computeAnswer() = {
    (1 to 1000000)
      .filter(P034.isCurious)
      .sum
      .toString
  }
}

object P034 {
  def isCurious(n: Int): Boolean = {
    val digits = CommonFunctions.getReverseDigitsIterator(n).toList
    if (digits.size > 1)
      digits.map(P020.factorialStream).sum.toInt == n
    else
      false
  }
}
