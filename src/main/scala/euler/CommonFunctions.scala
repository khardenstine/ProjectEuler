package euler

import scala.collection.mutable

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
    } else {
      new Iterator[Int] {
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

  lazy val TriangleNumbers: Stream[Int] = 1 #:: Stream.from(2).map(i => i + TriangleNumbers(i - 2))

  lazy val PentagonalNumbers: Stream[Int] = Stream.from(1).map(n => n * ((3 * n) - 1) / 2)

  lazy val HexagonalNumbers: Stream[Int] = Stream.from(1).map(n => n * ((2 * n) - 1))

  /**
   * Will return factors in order from smallest to largest
   */
  def getFactors(value: Long): Iterator[Long] = {
    val sqrt = Math.sqrt(value.toDouble)

    new Iterator[Long] {
      val largeFactors: mutable.Stack[Long] = mutable.Stack()
      var p: Long = 2L
      var nextFactor: Option[Long] = None

      private def assignNextFactor: Boolean = {
        while (p <= sqrt && value % p != 0) {
          p += 1
        }
        if (p <= sqrt) {
          if (p != sqrt) {
            largeFactors.push(value / p)
          }
          nextFactor = Some(p)
          p += 1
          true
        } else if (largeFactors.isEmpty) {
          nextFactor = None
          false
        } else {
          nextFactor = Some(largeFactors.pop())
          true
        }
      }

      def hasNext = {
        if (nextFactor.isEmpty) {
          assignNextFactor
          nextFactor.isDefined
        } else {
          true
        }
      }

      def next() = {
        val t = nextFactor.get
        nextFactor = None
        t
      }
    }
  }
}
