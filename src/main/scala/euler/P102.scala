package euler

import P102._

class P102 extends Problem {
  def computeAnswer() = {
    io.Source.fromURL(getClass.getResource("/p102_triangles.txt"))
      .getLines()
      .map(
        line =>
          line.split(",")
            .map(Integer.parseInt)
            .toList
            .grouped(2)
            .map(coords => Point(coords(0), coords(1)))
            .toList
      )
      .map(points => Triangle(points(0), points(1), points(2)))
      .count(_.containsOrigin())
  }
}

object P102 {
  case class Point(x: Double, y: Double)

  case class Line(pointA: Point, pointB: Point) {
    case class Range(smallest: Double, largest: Double) {
      def contains(value: Double): Boolean =
        smallest <= value && largest >= value
    }

    lazy val slope =
      (pointA.y - pointB.y) / (pointA.x - pointB.x)

    lazy val yIntercept: Double = pointA.y - (slope * pointA.x)

    lazy val xRange = {
      if (pointA.x < pointB.x)
        Range(pointA.x, pointB.x)
      else
        Range(pointB.x, pointA.x)
    }

    lazy val yRange = {
      if (pointA.y < pointB.y)
        Range(pointA.y, pointB.y)
      else
        Range(pointB.y, pointA.y)
    }

    lazy val pointSlopeEquation = s"y = ${slope}x + $yIntercept"

    def solveFor(x: Double): Option[Double] = {
      if (xRange.contains(x)) {
        val y = (slope * x) + yIntercept
        if (yRange.contains(y)) Some(y)
        else None
      } else
        None
    }

    def intersects(that: Line): Boolean = {
      val x = (that.yIntercept - this.yIntercept) / (this.slope - that.slope)

      this.solveFor(x).isDefined && that.solveFor(x).isDefined
    }
  }

  private val OriginRight = Line(Point(0, 0), Point(Double.MaxValue, 0))

  case class Triangle(pointA: Point, pointB: Point, pointC: Point) {
    val lines = Seq(
      Line(pointA, pointB),
      Line(pointA, pointC),
      Line(pointB, pointC)
    )

    def containsOrigin(): Boolean = {
      lines.count(_.intersects(OriginRight)) == 1
    }
  }
}
