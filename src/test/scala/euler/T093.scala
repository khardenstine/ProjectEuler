package euler

import org.scalatest.FunSuite

class T093 extends FunSuite {
  test("digitSets less than 5 is only Set(1, 2, 3, 4)") {
    val digitSets = P093.getDigitSetsLessThan(5)
    assert(digitSets.size == 1)
    assert(digitSets.head == Set(1, 2, 3, 4))
  }

  test("consecutive expressible numbers of (1, 2, 3, 4) is 28") {
    assert(P093.calculateConsecutiveExpressibleNumbers(Set(1, 2, 3, 4)) == 28)
  }

  test("expressible numbers of (1, 2, 3, 4)") {
    val expressiblePositiveNumbers = P093.getAllComputationCombinations(Set(1, 2, 3, 4))
      .flatMap(_.value)
      .filter(i => i > 0 && i % 1 == 0)
    assert(expressiblePositiveNumbers.size == 31)
    assert(expressiblePositiveNumbers.max == 36)
  }
}
