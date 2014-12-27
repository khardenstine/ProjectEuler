package euler

class P001 extends Problem {
  def computeAnswer() = P001.sumOfMultiplesBelow(1000).toString
}

object P001 {
  def sumOfMultiplesBelow(below: Int): Int = {
    (0 until below).filter(isMultipleOf3or5).sum
  }

  def isMultipleOf3or5(number: Int): Boolean = {
    number % 3 == 0 || number % 5 == 0
  }
}
