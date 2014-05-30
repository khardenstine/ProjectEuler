package euler

import org.scalatest.FunSuite

class T002 extends FunSuite{
	test("fib itr 89") {
		val fib89 = P002.buildFibonacciItr(89).toList
		assert(fib89.length == 10)
		assert(
			fib89(0) == 1 &&
			fib89(1) == 2 &&
			fib89(2) == 3 &&
			fib89(3) == 5 &&
			fib89(4) == 8 &&
			fib89(5) == 13 &&
			fib89(6) == 21 &&
			fib89(7) == 34 &&
			fib89(8) == 55 &&
			fib89(9) == 89
		)
	}

	test("fib itr 90's max element is 89") {
		assert(P002.buildFibonacciItr(90).toList.max == 89)
	}
}
