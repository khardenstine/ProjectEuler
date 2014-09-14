package euler

import org.scalatest.FunSuite

class T003 extends FunSuite{
	test("largest prime factor of 13195 is 29") {
		assert(P003.getLargestPrimeFactor(13195) == 29)
	}

	test("find prime factors of 13195") {
		val computedPrimes: Seq[Long] = CommonFunctions.getFactors(13195).filter(P003.isPrime).toSeq
		val hardCodedPrimes: Seq[Long] = Seq(5, 7, 13, 29)

		assert(computedPrimes equals hardCodedPrimes)
	}

	test("5, 7, 13, 29 are prime") {
		assert(Seq(5, 7, 13, 29).forall(P003.isPrime(_)))
	}

	test("4, 8, 10, 51 are not prime") {
		assert(Seq(4, 8, 10, 51).forall(!P003.isPrime(_)))
	}
}
