package euler

import org.scalatest.FunSuite

class T010 extends FunSuite{
	test("sum of the primes below 10 is 17") {
		assert(P010.sumOfPrimesBelow(10) == BigInt(17))
	}
}
