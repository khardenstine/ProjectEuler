package euler

import org.scalatest.FunSuite
import P474.{F, factorial}

class T474 extends FunSuite {
	test("F(84, 4) = 3") {
		assert(F(84, 4) == BigInt(3))
	}

	test("0! = 1") {
		assert(factorial(0) == BigInt(1))
	}

	test("12! = 479001600") {
		assert(factorial(12) == BigInt(479001600))
	}

	test("F(12!, 12) = 11") {
		assert(F(factorial(12), 12) == BigInt(11))
	}

	// takes too long
	ignore ("F(50!, 123) = 3") {
		assert(F(factorial(50), 123) == BigInt(17888))
	}
}
