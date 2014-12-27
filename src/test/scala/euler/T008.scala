package euler

import org.scalatest.FunSuite

class T008 extends FunSuite {
  test("The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.") {
    assert(P008.getLargestProduct(4) == 5832)
  }
}
