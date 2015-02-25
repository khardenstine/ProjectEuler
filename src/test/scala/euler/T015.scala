package euler

import P015._
import org.scalatest.FunSuite

class T015 extends FunSuite {
  test("1×1 grid has 2 unique paths") {
    assert(totalPaths(1, 1) == BigInt(2))
  }

  test("1×2 and 2×1 grid have 3 unique paths") {
    assert(totalPaths(1, 2) == BigInt(3))
    assert(totalPaths(2, 1) == BigInt(3))
  }

  test("2×2 grid has 6 unique paths") {
    assert(totalPaths(2, 2) == BigInt(6))
  }
}
