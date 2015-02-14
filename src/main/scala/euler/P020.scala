package euler

class P020 extends Problem {
  def computeAnswer() = {
    CommonFunctions.sumOfDigits(CommonFunctions.FactorialStream(100))
  }
}
