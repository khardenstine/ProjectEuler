package euler

class P067 extends Problem {
  def computeAnswer() = {
    val triangle = io.Source.fromURL(getClass.getResource("/p067_triangle.txt"))
      .getLines()
      .map(_.split(" ").map(Integer.parseInt).toList)
      .toList

    P018.calculateMaximumTotal(triangle)
  }
}
