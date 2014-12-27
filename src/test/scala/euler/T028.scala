package euler

import org.scalatest.FunSuite

class T028 extends FunSuite {
  test("diagonals for 5x5 square") {
    assert(P028.getDiagonalsForSquare(5).toSeq == Seq(1, 3, 5, 7, 9, 13, 17, 21, 25))
  }

  test("sum of diagonals of 5x5 square is 101") {
    assert(P028.getDiagonalsForSquare(5).sum == 101)
  }
}
