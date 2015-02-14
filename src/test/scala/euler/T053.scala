package euler

import P053._
import org.scalatest.FunSuite

class T053 extends FunSuite {
  test("5C3 = 10") {
    assert(combinations(5, 3) == BigInt(10))
  }

  test("23C10 = 1144066") {
    assert(combinations(23, 10) == BigInt(1144066))
  }
}
