package euler

class P025 extends Problem {
	def computeAnswer() = {
		P025.getFirstFibonacciTermWithDigits(1000)._2.toString
	}
}

object P025 {
	def getFirstFibonacciTermWithDigits(digits: Int): (BigInt, Int) = {
		val t = (1 until digits).foldLeft(BigInt(1))((a, b) => a * BigInt(10))
		CommonFunctions.Fibonacci.zipWithIndex.find(_._1 >= t).get
	}
}
