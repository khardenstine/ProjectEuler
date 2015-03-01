package euler

import P048._
import org.scalatest.FunSuite

class T048 extends FunSuite {
  test("sum of self powers 1 to 10 is 10405071317") {
    assert((1 to 10).map(selfPower).sum == BigInt(10405071317L))
  }
}
