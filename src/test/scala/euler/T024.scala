package euler

import P024._
import org.scalatest.FunSuite

class T024 extends FunSuite {
  test("3124 is one possible permutation of the digits 1, 2, 3 and 4") {
    assert(getLexographicalPermutations((1 to 4).toStream).contains("3124"))
  }

  test("The lexogrpahical permutations of 0, 1, and 2 are (012, 021, 102, 120, 201, 210)") {
    assert(getLexographicalPermutations((0 to 2).toStream) == Stream("012", "021", "102", "120", "201", "210"))
  }
}
