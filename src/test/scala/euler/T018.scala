package euler

import P018._
import org.scalatest.FunSuite

class T018 extends FunSuite {
  val EXAMPLE_TRIANGLE = List(
    List(3),
    List(7, 4),
    List(2, 4, 6),
    List(8, 5, 9, 3)
  )

  test("maximum total of the small triangle is 23") {
    assert(calculateMaximumTotal(EXAMPLE_TRIANGLE) == 23)
  }
}
