package euler

import org.scalatest.FunSuite

class CommonFunctionsTest extends FunSuite{
	test("sum of digits of 2^15 is 26") {
		// P016
		assert(CommonFunctions.sumOfDigits(P016.bigIntPow(2, 15)) == 26)
	}

	test("sum of digits of 3628800 is 27") {
		// P020
		assert(CommonFunctions.sumOfDigits(3628800) == 27)
	}
}
