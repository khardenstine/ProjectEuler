package euler

import org.scalatest.FunSuite

class T035 extends FunSuite {
  test("2, 3, 79, and, 197 are circular primes") {
    val primes = CommonFunctions.Primes.takeWhile(_ < 1000).toSet
    assert(Seq(2, 3, 79, 197).forall(P035.isCircularPrime(_, primes)))
  }

  test("197 has the rotations 197, 971, and 719") {
    assert(P035.getAllRotations(197) equals Set(197, 971, 719))
  }

  test("there are 13 circular primes below 100") {
    assert(P035.countCircularPrimesBelow(100) == 13)
  }
}
