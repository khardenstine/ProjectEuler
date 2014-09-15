package euler

import org.scalatest.FunSuite

class T034 extends FunSuite {
  test("145 is curious") {
    assert(P034.isCurious(145))
  }

  test("1 is not curious") {
    assert(!P034.isCurious(1))
  }

  test("2 is not curious") {
    assert(!P034.isCurious(2))
  }
}
