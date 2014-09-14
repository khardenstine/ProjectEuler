package euler

import P023._
import org.scalatest.FunSuite

class T023 extends FunSuite {
  test("28 is a perfect number") {
    assert(isPerfect(28))
  }

  test("12 is an abundant number") {
    assert(isAbundant(12))
  }

  test("24 is sum of two abundant numbers") {
    assert(isSumOf2AbundantNumbers(24))
  }

  test("28124 is sum of two abundant numbers") {
    assert(isSumOf2AbundantNumbers(28124))
  }
}
