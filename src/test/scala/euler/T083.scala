package euler

import P083._
import org.scalatest.FunSuite

class T083 extends FunSuite {
  val TEST_MATRIX = Array(
    Array(131, 673, 234, 103, 18),
    Array(201, 96, 342, 965, 150),
    Array(630, 803, 746, 422, 111),
    Array(537, 699, 497, 121, 956),
    Array(805, 732, 524, 37, 331)
  )

  test("TEST_MATRIX shortest path is 2297") {
    assert(matrixToGraph(TEST_MATRIX).shortestPath() == Some(2297))
  }
}
