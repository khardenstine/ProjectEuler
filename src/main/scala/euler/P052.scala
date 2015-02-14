package euler

import P052._

class P052 extends Problem {
  def computeAnswer() = {
    Stream.from(1)
      .map(getMultiples(_, (1 to 6).toSet).toSeq)
      .find(sameDigits(_: _*))
      .get
      .min // since n * 1 is included, we just grab the min (the seq is not ordered)
      .toString
  }
}

object P052 {
  def sameDigits(numbers: Int*): Boolean = {
    val digitSeq = numbers.map(CommonFunctions.getReverseDigitsIterator(_).toSet)
    digitSeq
      .foldLeft(true) {
        case (bool: Boolean, digitSet: Set[Int]) =>
          bool && digitSet == digitSeq.head
      }
  }

  def getMultiples(n: Int, whichMultiples: Set[Int]): Set[Int] = whichMultiples.map(n * _)
}
