package euler

import org.scalatest.FunSuite

class T038 extends FunSuite {
  test("192, 3 is pandigital") {
    assert(P038.isPandigital(192, 3))
  }

  test("9, 5 is pandigital") {
    assert(P038.isPandigital(9, 5))
  }
}
