package euler

object CommonFunctions {
	def sumOfDigits(num: BigInt): Int = {
		getReverseDigitsIterator(num).sum
	}

	/**
	 * getDigitsIterator(5012).toSeq will return Seq(2, 1, 0, 5)
	 * @return digits in reverse
	 */
	def getReverseDigitsIterator(num: BigInt): Iterator[Int] = {
		assert(num >= 0, "only supports non-negative integers")
		if (num == BigInt(0)) {
			Seq(0).iterator
		}
		else {
			new Iterator[Int]{
				private var i = num
				def hasNext = i > 0
				def next() = {
					val remainder = i % 10
					i /= 10
					remainder.toInt
				}
			}
		}
	}

	lazy val Primes: Stream[Int] = {
		2 #:: Stream.from(3).filter(i =>
			Primes.takeWhile(Math.pow(_, 2) <= i)
				.forall(i % _ != 0)
		)
	}

	lazy val Fibonacci: Stream[BigInt] = {
		BigInt(0) #:: BigInt(1) #:: Fibonacci.zip(Fibonacci.tail).map(pair => pair._1 + pair._2)
	}
}
