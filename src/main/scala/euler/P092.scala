package euler

class P092 extends Problem {
  def computeAnswer() = {
    (1 until 10000000).count(P092.chainEndsAt89).toString
  }
}

object P092 {

  def chainEndsAt89(num: Int): Boolean = {
    if (num == 89) {
      true
    } else if (num == 1) {
      false
    } else {
      chainEndsAt89(sumOfSquaredDigits(num))
    }
  }

  def sumOfSquaredDigits(num: Int): Int = {
    if (num < 1) { sys.error("only supports positive integers") }
    var sum = 0
    var i = num
    while (i > 0) {
      val mod = i % 10
      sum += mod * mod
      i /= 10
    }
    sum
  }
}
