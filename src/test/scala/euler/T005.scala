package euler

import org.scalatest.FunSuite

class T005 extends FunSuite{
	test("2520 is smallest divisor of 1 through 10") {
		assert(P005.getSmallestDividend(1 to 10) == 2520)
	}
}
