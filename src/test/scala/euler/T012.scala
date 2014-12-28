package euler

import org.scalatest.FunSuite

class T012 extends FunSuite {
  test("28 is the first triangle with over 5 divisors") {
    assert(P012.findFirstTriangleNumberWithDivisors(5) == 28)
  }
}
