package euler

class P039 extends Problem {
  import P039._

  def computeAnswer() = {
    (3 to 1000)
      .map(p => (p, rightTrianglesWithPerimeter(p).size))
      .maxBy(tup => tup._2)
      ._1
      .toString
  }
}

object P039 {
  /*
   * All sides of a triangle must be smaller than the sum of the other two sides
   */
  def isTriangle(a: Int, b: Int, c: Int): Boolean = {
    (a + b > c) && (a + c > b) && (b + c > a)
  }

  def isRightTriangle(a: Int, b: Int, c: Int): Boolean = {
    val sortedSquares = Seq(a, b, c)
      .map(Math.pow(_, 2))
      .sorted
    sortedSquares(0) + sortedSquares(1) == sortedSquares(2)
  }

  def triplesThatSumToValue(value: Int): Seq[(Int, Int, Int)] = for (
    a <- 1 to (value - 2);
    b <- 1 to (value - (a + 1))
  ) yield (a, b, value - (a + b))

  def rightTrianglesWithPerimeter(perimeter: Int): Set[List[Int]] = {
    triplesThatSumToValue(perimeter)
      .filter(Function.tupled(isTriangle))
      .filter(Function.tupled(isRightTriangle))
      .map(tup => List(tup._1, tup._2, tup._3).sorted)
      .toSet
  }
}
