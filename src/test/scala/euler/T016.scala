package euler

import org.scalatest.FunSuite

class T016 extends FunSuite{
	test("2^15 is 32768") {
		assert(P016.bigIntPow(2, 15) == BigInt(32768))
	}

	test("sum of digits of 2^15 is 26") {
		assert(P016.sumOfDigits(P016.bigIntPow(2, 15)) == 26)
	}
}
