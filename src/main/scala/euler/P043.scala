package euler

class P043 extends Problem {
  import P043._

  def computeAnswer() = {
    PandigitalNumbers
      .filter(_.isSubstringDivisible)
      .map(_.value)
      .sum
  }
}

object P043 {
  def buildInt(digits: Int*): Int = {
    digits
      .reverse
      .zipWithIndex
      .foldLeft(0)((a, b) => a + (b._1 * Math.pow(10, b._2).toInt))
  }

  def buildBigInt(digits: Int*): BigInt = {
    digits
      .reverse
      .zipWithIndex
      .foldLeft(BigInt(0))((a, b) => a + (b._1 * BigInt(10).pow(b._2)))
  }

  case class Number(
      d1: Int,
      d2: Int,
      d3: Int,
      d4: Int,
      d5: Int,
      d6: Int,
      d7: Int,
      d8: Int,
      d9: Int,
      d10: Int
  ) {
    def value = buildBigInt(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10)

    def isSubstringDivisible: Boolean = {
      0 == buildInt(d2, d3, d4) % 2 && //    d2 d3 d4  is divisible by 2
        0 == buildInt(d3, d4, d5) % 3 && //  d3 d4 d5  is divisible by 3
        0 == buildInt(d4, d5, d6) % 5 && //  d4 d5 d6  is divisible by 5
        0 == buildInt(d5, d6, d7) % 7 && //  d5 d6 d7  is divisible by 7
        0 == buildInt(d6, d7, d8) % 11 && // d6 d7 d8  is divisible by 11
        0 == buildInt(d7, d8, d9) % 13 && // d7 d8 d9  is divisible by 13
        0 == buildInt(d8, d9, d10) % 17 //   d8 d9 d10 is divisible by 17
    }
  }

  private val validDigits = (0 to 9).toSet

  lazy val PandigitalNumbers = for (
    a <- validDigits;
    b <- validDigits.diff(Set(a));
    c <- validDigits.diff(Set(a, b));
    d <- validDigits.diff(Set(a, b, c));
    e <- validDigits.diff(Set(a, b, c, d));
    f <- validDigits.diff(Set(a, b, c, d, e));
    g <- validDigits.diff(Set(a, b, c, d, e, f));
    h <- validDigits.diff(Set(a, b, c, d, e, f, g));
    i <- validDigits.diff(Set(a, b, c, d, e, f, g, h));
    j <- validDigits.diff(Set(a, b, c, d, e, f, g, h, i))
  ) yield Number(a, b, c, d, e, f, g, h, i, j)
}
