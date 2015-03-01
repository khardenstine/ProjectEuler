package euler

import P046._
import org.scalatest.FunSuite

class T046 extends FunSuite {
  /*
  9 = 7 + 2×1^2
  15 = 7 + 2×2^2
  21 = 3 + 2×3^2
  25 = 7 + 2×3^2
  27 = 19 + 2×2^2
  33 = 31 + 2×1^2
   */
  test("9, 15, 21, 25, 27, and 33 can all be written as the sum of a prime and double square") {
    assert(List(9, 15, 21, 25, 27, 33).forall(sumOfPrimeAndDoubleSquare))
  }
}
