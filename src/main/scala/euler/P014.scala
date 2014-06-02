package euler

class P014 extends Problem {
	def computeAnswer() = {
		var largest = (1, 1)
		(1 until 1000000).foreach{
			i =>
				val len = P014.getChainLength(i)
				if (largest._2 < len){
					largest = (i, len)
				}
		}
		largest._1.toString
	}
}


object P014 {
	def getChainLength(num: Long, currentCount: Int = 0): Int = {
		if (num == 1) {
			currentCount + 1
		}
		else if (num % 2 == 0){
			getChainLength(num / 2, currentCount + 1)
		}
		else {
			getChainLength((3 * num) + 1, currentCount + 1)
		}
	}
}
