package euler

class P007 extends Problem {
	def computeAnswer() = {
		P007.primes(10000).toString
	}
}

object P007 {
	lazy val primes: Stream[Int] = {
		2 #:: Stream.from(3).filter(i =>
			primes.takeWhile(Math.pow(_, 2) <= i)
				.forall(i % _ != 0)
		)
	}
}