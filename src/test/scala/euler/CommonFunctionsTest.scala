package euler

import org.scalatest.FunSuite
import CommonFunctions._

class CommonFunctionsTest extends FunSuite {
  test("sum of digits of 2^15 is 26") {
    // P016
    assert(sumOfDigits(P016.bigIntPow(2, 15)) == 26)
  }

  test("sum of digits of 3628800 is 27") {
    // P020
    assert(sumOfDigits(3628800) == 27)
  }

  test("the first 6 primes are 2, 3, 5, 7, 11, 13") {
    // P007
    assert(Primes.take(6).toSeq equals Seq(2, 3, 5, 7, 11, 13))
  }

  test("the first 6 composites are 4, 6, 8, 9, 10, 12") {
    assert(CompositeNumbers.take(6).toSeq equals Seq(4, 6, 8, 9, 10, 12))
  }

  test("digits iterator expands correctly") {
    assert(getReverseDigitsIterator(3628800).toList == Seq(0, 0, 8, 8, 2, 6, 3))
    assert(getReverseDigitsIterator(0).toList == Seq(0))
  }

  test("fibonacci stream where i <= 89") {
    val fib89 = Fibonacci.takeWhile(_ <= BigInt(89))
    assert(fib89.length == 12)
    assert(
      fib89(0) == BigInt(0) &&
        fib89(1) == BigInt(1) &&
        fib89(2) == BigInt(1) &&
        fib89(3) == BigInt(2) &&
        fib89(4) == BigInt(3) &&
        fib89(5) == BigInt(5) &&
        fib89(6) == BigInt(8) &&
        fib89(7) == BigInt(13) &&
        fib89(8) == BigInt(21) &&
        fib89(9) == BigInt(34) &&
        fib89(10) == BigInt(55) &&
        fib89(11) == BigInt(89)
    )
  }

  test("20 has the factors 2, 4, 5, 10") {
    assert(Seq(2, 4, 5, 10) equals getFactors(20).toSeq)
  }

  test("49 has the factor 7") {
    assert(Seq(7) equals getFactors(49).toSeq)
  }

  test("first 10 triangle numbers") {
    assert(TriangleNumbers.take(10).toList == List(1, 3, 6, 10, 15, 21, 28, 36, 45, 55))
  }

  test("first 10 pentagonal numbers") {
    assert(PentagonalNumbers.take(10).toList == List(1, 5, 12, 22, 35, 51, 70, 92, 117, 145))
  }

  test("first 5 hexagonal numbers") {
    assert(HexagonalNumbers.take(5).toList == List(1, 6, 15, 28, 45))
  }

  test("0! is 1") {
    assert(FactorialStream(0) == BigInt(1))
  }

  test("1! is 1") {
    assert(FactorialStream(1) == BigInt(1))
  }

  test("10! is 3628800") {
    assert(FactorialStream(10) == BigInt(3628800))
  }
}
