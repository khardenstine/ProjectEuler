package euler

import org.scalatest.FunSuite
import P017._

class T017 extends FunSuite{
	test("342 is three hundred and forty-two") {
		assert(numberToWords(342) == "three hundred and forty-two")
	}

	test("115 is one hundred and fifteen") {
		assert(P017.numberToWords(115) == "one hundred and fifteen")
	}

	test("342 toWords contains 23 characters") {
		assert(filteredStringLength(numberToWords(342)) == 23)
	}

	test("115 toWords contains 20 characters") {
		assert(filteredStringLength(numberToWords(115)) == 20)
	}
}
