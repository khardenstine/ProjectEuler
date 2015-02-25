package euler

import P015._

class P015 extends Problem {
  def computeAnswer() = {
    totalPaths(20, 20)
  }
}

object P015 {
  def totalPaths(height: Int, width: Int): BigInt = {
    val matrix = (0 to height).map(
      _ => (0 to width).map(_ => BigInt(0)).toArray
    ).toArray

    (0 to width).foreach {
      x =>
        (0 to height).foreach {
          y =>
            var sum = matrix(y)(x)
            if (x > 0) sum = sum + matrix(y)(x - 1)
            if (y > 0) sum = sum + matrix(y - 1)(x)
            if (BigInt(0) == sum) sum = 1

            matrix(y).update(x, sum)
        }
    }

    matrix.last.last
  }
}
