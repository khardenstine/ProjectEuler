package euler

import org.scalatest.FunSuite

class T007 extends FunSuite{
	test("the first 6 primes are 2, 3, 5, 7, 11, 13") {
		assert(P007.primes.take(6).toSeq equals Seq(2, 3, 5, 7, 11, 13))
	}
}
