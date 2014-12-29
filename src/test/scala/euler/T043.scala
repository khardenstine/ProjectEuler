package euler

import P043._
import org.scalatest.FunSuite

class T043 extends FunSuite {
  test("Number(1, 4, 0, 6, 3, 5, 7, 2, 8, 9).value == BigInt(1406357289)") {
    assert(Number(1, 4, 0, 6, 3, 5, 7, 2, 8, 9).value == BigInt(1406357289))
  }

  test("buildInt") {
    assert(buildInt(1, 2, 3) == 123)
    assert(buildInt(0, 0, 1) == 1)
    assert(buildInt(9, 9, 9, 9) == 9999)
  }

  test("buildBigInt") {
    assert(buildBigInt(1, 2, 3) == BigInt(123))
    assert(buildBigInt(0, 0, 1) == BigInt(1))
    assert(buildBigInt(9, 9, 9, 9) == BigInt(9999))
  }

  test("1406357289 is substring divisible") {
    assert(Number(1, 4, 0, 6, 3, 5, 7, 2, 8, 9).isSubstringDivisible)
  }

  test("4106357928 is NOT substring divisible") {
    assert(!Number(4, 1, 0, 6, 3, 5, 7, 9, 2, 8).isSubstringDivisible)
  }
}
