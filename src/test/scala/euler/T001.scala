package euler

import org.scalatest.FunSuite

class T001 extends FunSuite {
  test("isMultipleOf3or5") {
    assert(P001.isMultipleOf3or5(3))
    assert(P001.isMultipleOf3or5(500))

    assert(!P001.isMultipleOf3or5(1))
    assert(!P001.isMultipleOf3or5(2))
  }

  test("sumOfMultiplesBelow 10 is 23") {
    assert(P001.sumOfMultiplesBelow(10) == 23)
  }
}
