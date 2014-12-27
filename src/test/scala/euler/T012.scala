package euler

import org.scalatest.FunSuite

class T012 extends FunSuite {
  test("the 7th triangle is 28") {
    assert(P012.triangleNumber(6) == 28)
  }

  test("28 is the first triangle with over 5 divisors") {
    assert(P012.findFirstTriangleNumberWithDivisors(5) == 28)
  }
}
