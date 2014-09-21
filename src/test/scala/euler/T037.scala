import euler.P037
import org.scalatest.FunSuite

class T037 extends FunSuite {
  test("3797 has the truncations 3797,3,797,37,97,379,7") {
    assert(Set(3797, 797, 97, 7, 379, 37, 3) == P037.truncations(3797).toSet)
  }

  test("3797 is truncatable") {
    assert(P037.isTruncatable(3797))
  }
}
