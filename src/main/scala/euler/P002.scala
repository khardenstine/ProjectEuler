package euler

class P002 extends Problem {
	def computeAnswer() = {
		P002.buildFibonacciItr(4000000)
			.filter(_ % 2 == 0)
			.sum
			.toString
	}
}

object P002 {
	def buildFibonacciItr(maxValue: Int): Iterator[Int] = {
		new Iterator[Int]{
			private var vPrevious: Int = 0
			private var vCurrent: Int = 1
			private var vNext: Int = vPrevious + vCurrent

			def hasNext: Boolean = vNext <= maxValue
			def next(): Int = {
				vPrevious = vCurrent
				vCurrent = vNext
				vNext = vPrevious + vCurrent
				vCurrent
			}
		}
	}
}
