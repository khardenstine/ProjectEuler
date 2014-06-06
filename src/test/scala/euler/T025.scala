package euler

import org.scalatest.FunSuite

class T025 extends FunSuite {
	test("first fibonacci with 3 digits is 144") {
		assert(P025.getFirstFibonacciTermWithDigits(3)._1 == BigInt(144))
	}

	test("first fibonacci term with 3 digits is 12") {
		assert(P025.getFirstFibonacciTermWithDigits(3)._2 == 12)
	}
}
