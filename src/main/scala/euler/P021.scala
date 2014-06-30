package euler

class P021 extends Problem {
	def computeAnswer() = {
		(1 until 10000)
			.filter(P021.isAmicable)
			.sum
			.toString
	}
}

object P021 {
	def d(n: Int): Int = {
		assert(n > 0)
		// P003.getFactors does not include 1
		P003.getFactors(n).sum.toInt + 1
	}

	def isAmicable(n: Int): Boolean = {
		val dn = d(n)
		(dn != n) && (d(dn) == n)
	}
}
