package euler

class P040 extends Problem {
  import P040._

  def computeAnswer() = {
    (0 to 6)
      .map(Math.pow(10, _).toInt)
      .map(d)
      .foldLeft(1)(_ * _)
      .toString
  }
}

object P040 {
  val digitStream: Stream[Int] = Stream.from(1)
    .flatMap(i => {
      CommonFunctions.getReverseDigitsIterator(i)
        .toSeq
        .reverse
        .toStream
    })

  def d(n: Int): Int = digitStream(n - 1)
}
