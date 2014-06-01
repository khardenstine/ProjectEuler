package euler

class P009 extends Problem {
	def computeAnswer() = {
		P009.findTripletsForSum(1000)
			.map(t => t._1 * t._2 * t._3)
			.foldLeft("")(_ + _ + "\n")
	}
}

object P009 {
	def isPythagoreanTriplet(a: Int, b: Int, c: Int): Boolean = {
		(a * a) + (b * b) == (c * c)
	}

	def findTripletsForSum(sum: Int): Seq[(Int, Int, Int)] = {
		val aRange = 1 until sum / 3
		val bRange = 2 until sum / 2

		val triplets = aRange.map(a => bRange.map(b => (a, b, sum - (a + b)))).flatten
		triplets.filter((isPythagoreanTriplet _).tupled)
	}
}
