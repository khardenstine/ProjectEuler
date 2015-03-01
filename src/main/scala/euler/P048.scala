package euler

import P048._

class P048 extends Problem {
  def computeAnswer() = {
    (1 to 1000)
      .map(selfPower)
      .sum
      .toString()
      .takeRight(10)
  }
}

object P048 {
  def selfPower(n: Int): BigInt = BigInt(n).pow(n)
}
