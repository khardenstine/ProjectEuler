package euler

import P474.{F, factorial}

class P474 extends Problem {
	def computeAnswer() = {
		val answer = F(factorial(Math.pow(10, 6).toInt), 65432) % BigInt(Math.pow(10, 16).toLong + 61L)
		answer.toString()
	}
}

object P474 {
	def F(n: BigInt, d: Int): BigInt = {
		val digits = d.toString.length
		val E = BigInt(Math.pow(10, digits).toLong)

		// Range 0 to (n / E)
		val bigItr = new Iterator[BigInt]{
			private var num = BigInt(0)
			def hasNext = num <= (n / E)
			def next() = {
				val t = num
				num = num + 1
				t
			}
		}

		bigItr.count(start => n % ((start * E) + d) == BigInt(0))
	}

	def factorial(num: Int): BigInt = {
		if (num < 0) { sys.error("accepts non-negative integers only") }

		def fact(i: Int, product: BigInt): BigInt = {
			if (i > num) {
				product
			}
			else {
				fact(i + 1, product * i)
			}
		}
		fact(1, 1)
	}
}
