package euler

import org.scalatest.FunSuite
import P021.{ d, isAmicable }

class T021 extends FunSuite {
  test("d(220) is 284 and d(284) is 220") {
    assert(d(220) == 284)
    assert(d(284) == 220)
  }

  test("220 and 284 are amicable numbers") {
    assert(isAmicable(220))
    assert(isAmicable(284))
  }
}
