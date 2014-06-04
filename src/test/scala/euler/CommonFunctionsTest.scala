package euler

import org.scalatest.FunSuite
import CommonFunctions._

class CommonFunctionsTest extends FunSuite{
	test("sum of digits of 2^15 is 26") {
		// P016
		assert(sumOfDigits(P016.bigIntPow(2, 15)) == 26)
	}

	test("sum of digits of 3628800 is 27") {
		// P020
		assert(sumOfDigits(3628800) == 27)
	}

	test("the first 6 primes are 2, 3, 5, 7, 11, 13") {
		// P007
		assert(Primes.take(6).toSeq equals Seq(2, 3, 5, 7, 11, 13))
	}
}
