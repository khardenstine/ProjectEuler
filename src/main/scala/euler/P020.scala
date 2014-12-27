package euler

class P020 extends Problem {
  def computeAnswer() = {
    CommonFunctions.sumOfDigits(P020.factorialStream(100)).toString
  }
}

object P020 {
  lazy val factorialStream: Stream[BigInt] = BigInt(1) #:: Stream.from(1).map(i => i * factorialStream(i - 1))
}