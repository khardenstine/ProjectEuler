package euler

import org.scalatest.FunSuite

class T003 extends FunSuite{
	test("largest prime factor of 13195 is 29") {
		assert(P003.getLargestPrimeFactor(13195) == 29)
	}

	test("find prime factors of 13195") {
		val computedPrimes: Seq[Long] = P003.getFactors(13195).filter(P003.isPrime).toSeq
		val hardCodedPrimes: Seq[Long] = Seq(5, 7, 13, 29)

		assert(computedPrimes equals hardCodedPrimes)
	}

	test("5, 7, 13, 29 are prime") {
		assert(Seq(5, 7, 13, 29).forall(P003.isPrime(_)))
	}

	test("4, 8, 10, 51 are not prime") {
		assert(Seq(4, 8, 10, 51).forall(!P003.isPrime(_)))
	}

	test("20 has the factors 2, 4, 5, 10") {
		assert(Seq(2, 4, 5, 10) equals P003.getFactors(20).toSeq)
	}

	test("49 has the factors 7 and 7") {
		assert(Seq(7, 7) equals P003.getFactors(49).toSeq)
	}
}
