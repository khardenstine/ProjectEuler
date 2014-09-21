package euler

class P038 extends Problem {
  def computeAnswer() = {
    val products = for (
      i <- 1 to 9999;
      n <- 2 to 9
    ) yield P038.concatedProduct(i, n)

    products
      .filter(P038.isPandigital)
      .map(_.mkString)
      .max
  }
}

object P038 {
  private val digits = 1 to 9

  def concatedProduct(i: Int, n: Int): Seq[Int] = {
    (1 to n)
      .map(_ * i)
      .map(CommonFunctions.getReverseDigitsIterator(_).toSeq.reverse)
      .flatten
  }

  def isPandigital(productDigits: Seq[Int]) = {
    digits.diff(productDigits).isEmpty && productDigits.diff(digits).isEmpty
  }

  def isPandigital(i: Int, n: Int): Boolean = {
    isPandigital(concatedProduct(i, n))
  }
}
