package euler

class P028 extends Problem {
	def computeAnswer() = {
		P028.getDiagonalsForSquare(1001).sum.toString
	}
}

object P028 {
	def getDiagonalsForSquare(squareWidth: Int): Iterator[Int] = {
		val area = squareWidth * squareWidth
		new Iterator[Int] {
			var c = 1
			var increment = 0
			var timesIncremented = 3

			private def setIncrement() = {
				if (timesIncremented == 3) {
					// width of a square goes up by 2 every spiral
					increment += 2
					timesIncremented = 0
				}
				else {
					timesIncremented += 1
				}
			}

			def hasNext = c + increment <= area
			def next() = {
				c += increment
				setIncrement()
				c
			}
		}
	}
}
