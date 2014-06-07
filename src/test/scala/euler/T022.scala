package euler

import org.scalatest.FunSuite

class T022 extends FunSuite {
	test("COLIN is worth 53") {
	    assert(P022.getWorth("COLIN") == 53)
	}

	test("sumOfScores of Seq(COLIN, COLIN) is 159") {
		assert(P022.sumOfScores(Seq("COLIN", "COLIN")) == BigInt(159))
	}
}
