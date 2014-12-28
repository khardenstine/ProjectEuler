package euler

import CommonFunctions._

class P012 extends Problem {
  def computeAnswer() = {
    P012.findFirstTriangleNumberWithDivisors(500).toString
  }
}

object P012 {
  /**
   *
   * @param n number of divisors
   * @return the triangle number
   */
  def findFirstTriangleNumberWithDivisors(n: Int): Int = {
    TriangleNumbers.find {
      tri =>
        // P003.getFactors does not include the actual number or 1 as factors
        // thus it will always return 2 less than we want
        CommonFunctions.getFactors(tri).size + 2 > n
    }.get
  }
}
