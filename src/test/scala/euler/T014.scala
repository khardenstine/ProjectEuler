package euler

import org.scalatest.FunSuite

class T014 extends FunSuite {
	test("chain starting at 13 has a length of 10") {
		assert(P014.getChainLength(13) == 10)
	}
}
