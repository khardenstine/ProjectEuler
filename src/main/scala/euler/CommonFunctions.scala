package euler

object CommonFunctions {
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
}
