package euler

class P010 extends Problem {
	def computeAnswer() = {
		P010.sumOfPrimesBelow(2000000).toString
	}
}

object P010 {
	def sumOfPrimesBelow(i: Int): BigInt = {
		P007.primes.takeWhile(_ < i).map(BigInt(_)).sum
	}
}
