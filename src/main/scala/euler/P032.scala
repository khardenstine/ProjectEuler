package euler

class P032 extends Problem {
	def computeAnswer() = {
		val leftSides = for(
			a <- 1 to 9;
			b <- (1 to 9).filter(_ != a);
			c <- (1 to 9).filter(!Seq(a, b).contains(_));
			d <- (1 to 9).filter(!Seq(a, b, c).contains(_));
			e <- (1 to 9).filter(!Seq(a, b, c, d).contains(_))
		) yield Seq(a, b, c, d, e)

		leftSides.map{ seq =>
			(1 to 4).flatMap{ idx =>
				val mults = P032.splitDigitsIntoTwoNumbers(idx, seq)
				val product = mults._1 * mults._2
				val sProduct = product.toString
				val possibleProductDigits = (1 to 9).filter(!seq.contains(_))
				if (sProduct.length == 4 && possibleProductDigits.forall(digit => sProduct.contains(digit.toString))) {
					Some(product)
				}
				else {
					None
				}
			}
		}.flatten.toSet.sum.toString
	}
}

object P032 {
	def splitDigitsIntoTwoNumbers(idx: Int, seq: Seq[Int]): (Int, Int) = {
		(
			mergeDigits(seq.slice(0, idx)),
			mergeDigits(seq.slice(idx, seq.size))
		)
	}

	/**
	 *  e.g. Seq(1, 4, 3) returns the Int: 143
	 */
	def mergeDigits(seq: Seq[Int]): Int = {
		seq.foldLeft("")(_ + _).toInt
	}
}
