package euler

import P081._
import org.scalatest.FunSuite

class T081 extends FunSuite {
  val TEST_MATRIX = List(
    List(131, 673, 234, 103, 18),
    List(201, 96, 342, 965, 150),
    List(630, 803, 746, 422, 111),
    List(537, 699, 497, 121, 956),
    List(805, 732, 524, 37, 331)
  )

  test("TEST_MATRIX has a minimal path sum of 2427") {
    assert(calculateMinimalPathSum(TEST_MATRIX) == 2427)
  }
}
