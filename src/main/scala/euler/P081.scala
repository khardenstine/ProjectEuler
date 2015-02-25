package euler

import P081._

class P081 extends Problem {
  def computeAnswer() = {
    val matrix = io.Source.fromURL(getClass.getResource("/p081_matrix.txt"))
      .getLines()
      .map(_.split(",").map(Integer.parseInt).toList)
      .toList

    calculateMinimalPathSum(matrix)
  }
}

object P081 {
  def calculateMinimalPathSum(matrix: List[List[Int]]): Int = {
    val mutableMatrix: Array[Array[Int]] = matrix.map(_.toArray).toArray

    (0 until matrix.size).foreach {
      yIndex =>
        (0 until matrix.last.size).foreach {
          xIndex =>
            val opLeftValue = {
              if (xIndex > 0) Some(mutableMatrix(yIndex)(xIndex - 1))
              else None
            }
            val opAboveValue = {
              if (yIndex > 0) Some(mutableMatrix(yIndex - 1)(xIndex))
              else None
            }

            opLeftValue
              .map(
                leftValue =>
                  opAboveValue.map {
                    aboveValue =>
                      if (aboveValue < leftValue) aboveValue
                      else leftValue
                  }.getOrElse(leftValue)
              )
              .orElse(opAboveValue)
              .map {
                minParent =>
                  val currentValue = mutableMatrix(yIndex)(xIndex)
                  mutableMatrix(yIndex).update(xIndex, currentValue + minParent)
              }
        }
    }

    mutableMatrix.last.last
  }

}
