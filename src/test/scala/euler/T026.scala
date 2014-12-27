package euler

import euler.P026._
import org.scalatest.FunSuite

class T026 extends FunSuite {
  implicit val threshold = DEFAULT_THRESHOLD

  test("the unit fraction of 2 has no recurring cycle") {
    assert(getUnitFractionRecurringCycle(2).isEmpty)
  }

  test("the unit fraction of 3 has the recurring cycle of 3") {
    assert(getUnitFractionRecurringCycle(3) == Some("3"))
  }

  test("the unit fraction of 6 has the recurring cycle of 6") {
    assert(getUnitFractionRecurringCycle(6) == Some("6"))
  }

  test("the unit fraction of 7 has the recurring cycle of 142857") {
    assert(getUnitFractionRecurringCycle(7) == Some("142857"))
  }

  test("the largest recurring cycle less than 11 is 7") {
    assert(getLargestRecurringCycleLessThan(11) == 7)
  }
}
