package euler

import org.scalatest.FunSuite

class T006 extends FunSuite{
	test("385 is the sum of squares of the first 10 natural numbers") {
		assert(P006.getSumOfSquares(1 to 10) == 385)
	}

	test("3025 is the square of the sum of the first 10 natural numbers") {
		assert(P006.getSquareOfSum(1 to 10) == 3025)
	}
}
