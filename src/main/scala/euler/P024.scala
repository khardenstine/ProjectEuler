package euler

import P024._

class P024 extends Problem {
  def computeAnswer() = {
    getLexographicalPermutations((0 to 9).toStream)(999999)
  }
}

object P024 {
  def getLexographicalPermutations(digits: Stream[Int]): Stream[String] = {
    if (digits.size == 1)
      Stream(digits.head.toString)
    else {
      digits.flatMap {
        digit =>
          getLexographicalPermutations(digits.filterNot(_ == digit)).map(digit + _)
      }
    }
  }
}
