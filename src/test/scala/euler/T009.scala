package euler

import org.scalatest.FunSuite

class T009 extends FunSuite{
	test("3, 4, 5 is a pythagorean triplet") {
		assert(P009.isPythagoreanTriplet(3, 4, 5))
	}

	test("12 is the sum of the triplet 3, 4, 5") {
		val triplets = P009.findTripletsForSum(12)
		assert(triplets.length == 1)
		assert(triplets(0) == (3, 4, 5))
	}
}
