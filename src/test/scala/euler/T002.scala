package euler

import org.scalatest.FunSuite

class T002 extends FunSuite{
	test("fib itr 89") {
		val fib89 = P002.buildFibonacciItr(89).toList
		assert(fib89.length == 10)
		assert(
			fib89(0) == BigInt(1) &&
			fib89(1) == BigInt(2) &&
			fib89(2) == BigInt(3) &&
			fib89(3) == BigInt(5) &&
			fib89(4) == BigInt(8) &&
			fib89(5) == BigInt(13) &&
			fib89(6) == BigInt(21) &&
			fib89(7) == BigInt(34) &&
			fib89(8) == BigInt(55) &&
			fib89(9) == BigInt(89)
		)
	}

	test("fib itr 90's max element is 89") {
		assert(P002.buildFibonacciItr(90).max == BigInt(89))
	}
}
