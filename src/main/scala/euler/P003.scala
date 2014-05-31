package euler

import scala.collection.mutable

class P003 extends Problem {
	def computeAnswer() = {
		P003.getLargestPrimeFactor(600851475143L).toString
	}
}

object P003 {
	def getLargestPrimeFactor(value: Long): Long = {
		getFactors(value).filter(isPrime).max
	}

	def isPrime(value: Long): Boolean = {
		getFactors(value).isEmpty
	}

	/**
	 * Will return factors in order from smallest to largest
	 */
	def getFactors(value: Long): Iterator[Long] = {
		val sqrt = Math.sqrt(value.toDouble).toLong

		new Iterator[Long] {
			val largeFactors: mutable.Stack[Long] = mutable.Stack()
			var p: Long = 2L
			var nextFactor: Option[Long] = None

			private def assignNextFactor: Boolean = {
				while (p <= sqrt && value % p != 0) {
					p += 1
				}
				if (p <= sqrt) {
					largeFactors.push(value / p)
					nextFactor = Some(p)
					p += 1
					true
				}
				else if (largeFactors.isEmpty) {
					nextFactor = None
					false
				}
				else {
					nextFactor = Some(largeFactors.pop())
					true
				}
			}

			def hasNext = {
				if (nextFactor.isEmpty) {
					assignNextFactor
					nextFactor.isDefined
				} else {
					true
				}
			}

			def next() = {
				val t = nextFactor.get
				nextFactor = None
				t
			}
		}
	}
}
