package euler

class P012 extends Problem {
	def computeAnswer() = {
		P012.findFirstTriangleNumberWithDivisors(500).toString
	}
}

object P012 {
	lazy val triangleNumber: Stream[Int] = 1 #:: Stream.from(2).map(i => i + triangleNumber(i - 2))

	/**
	 *
	 * @param n number of divisors
	 * @return the triangle number
	 */
	def findFirstTriangleNumberWithDivisors(n: Int): Int = {
		triangleNumber.find{
			tri =>
				// P003.getFactors does not include the actual number or 1 as factors
				// thus it will always return 2 less than we want
				P003.getFactors(tri).size + 2 > n
		}.get
	}
}