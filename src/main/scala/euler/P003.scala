package euler

class P003 extends Problem {
	def computeAnswer() = {
		P003.getLargestPrimeFactor(600851475143L).toString
	}
}

object P003 {
	def getLargestPrimeFactor(value: Long): Long = {
    CommonFunctions.getFactors(value).filter(isPrime).max
	}

	def isPrime(value: Long): Boolean = {
		CommonFunctions.getFactors(value).isEmpty
	}
}
