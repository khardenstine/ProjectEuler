package euler

import P052._
import org.scalatest.FunSuite

class T052 extends FunSuite {
  test("152, 125, 215, 251, 512, and 521 have the same digits") {
    assert(sameDigits(152, 125, 215, 251, 512, 521))
  }

  test("50 and 51 do not have the same digits") {
    assert(!sameDigits(50, 51))
  }

  test("125874 and 251748 have the same digits") {
    assert(sameDigits(125874, 251748))
  }

  test("the first 5 multiples of 3 are 3, 6, 9, 12, 15") {
    assert(getMultiples(3, (1 to 5).toSet) == Set(3, 6, 9, 12, 15))
  }
}
