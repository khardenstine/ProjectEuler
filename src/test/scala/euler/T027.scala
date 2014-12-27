package euler

import org.scalatest.FunSuite

class T027 extends FunSuite {
  test("n² + n + 41 has 40 primes") {
    assert(P027.consecutivePrimes(1, 41) == 40)
  }

  test("n² - 79n + 1601 has 80 primes") {
    assert(P027.consecutivePrimes(-79, 1601) == 80)
  }
}
