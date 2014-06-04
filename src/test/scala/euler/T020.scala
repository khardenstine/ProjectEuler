package euler

import org.scalatest.FunSuite

class T020 extends FunSuite {
	test("0! is 1") {
		assert(P020.factorialStream(0) == BigInt(1))
	}

	test("1! is 1") {
		assert(P020.factorialStream(1) == BigInt(1))
	}

	test("10! is 3628800") {
		assert(P020.factorialStream(10) == BigInt(3628800))
	}
}
