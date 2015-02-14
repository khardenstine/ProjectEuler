package euler

import P053._

class P053 extends Problem {
  def computeAnswer() = {
    (1 to 100).map(
      n => (1 to n).count(combinations(n, _) > 1000000)
    ).sum.toString
  }
}

object P053 {
  implicit class FactorialWrapper(n: Int) {
    def ! = CommonFunctions.FactorialStream(n)
  }

  def combinations(n: Int, r: Int): BigInt = {
    assert(r <= n)
    n.! / (r.! * (n - r).!)
  }
}
