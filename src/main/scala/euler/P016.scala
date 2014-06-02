package euler

import P016._

class P016 extends Problem {
	def computeAnswer() = {
		sumOfDigits(bigIntPow(2, 1000)).toString
	}
}

object P016 {
	def sumOfDigits(num: BigInt): Int = {
		if (num < 0) { sys.error("only supports non-negative integers") }
		var sum: Int = 0
		var i = num
		while(i > 0) {
			sum += (i % 10).toInt
			i /= 10
		}
		sum
	}

	def bigIntPow(a: Int, b: Int): BigInt = {
		var result = BigInt(1)
		(0 until b).foreach{ _ =>
			result = result * a
		}
		result
	}
}
