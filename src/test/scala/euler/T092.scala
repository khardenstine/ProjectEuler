package euler

import org.scalatest.FunSuite

class T092 extends FunSuite {
  test("sumOfSquaredDigits of 44 = 32") {
    assert(P092.sumOfSquaredDigits(44) == 32)
  }

  test("chain starting with 44 does not end at 89") {
    assert(!P092.chainEndsAt89(44))
  }

  test("chain starting with 145 ends at 89") {
    assert(P092.chainEndsAt89(145))
  }
}
