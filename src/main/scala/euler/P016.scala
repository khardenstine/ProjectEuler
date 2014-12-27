package euler

import P016._

class P016 extends Problem {
  def computeAnswer() = {
    CommonFunctions.sumOfDigits(bigIntPow(2, 1000)).toString
  }
}

object P016 {
  def bigIntPow(a: Int, b: Int): BigInt = {
    var result = BigInt(1)
    (0 until b).foreach { _ =>
      result = result * a
    }
    result
  }
}
