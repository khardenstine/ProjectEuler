package euler

import P102._
import org.scalatest.FunSuite

class T102 extends FunSuite {
  test("A(-340,495), B(-153,-910), C(835,-947) contains Origin") {
    assert(Triangle(
      Point(-340, 495),
      Point(-153, -910),
      Point(835, -947)
    ).containsOrigin())
  }

  test("X(-175,41), Y(-421,-714), Z(574,-645) does not contain Origin") {
    assert(!Triangle(
      Point(-175, 41),
      Point(-421, -714),
      Point(574, -645)
    ).containsOrigin())
  }
}
