package euler

import org.scalatest.FunSuite

class T032 extends FunSuite {
  test("mergeDigits") {
    assert(P032.mergeDigits(Seq(1, 4, 3)) == 143)
  }

  test("splitDigitsIntoTwoNumbers") {
    assert(P032.splitDigitsIntoTwoNumbers(3, Seq(1, 4, 3, 5, 3)) == (143, 53))
  }
}
