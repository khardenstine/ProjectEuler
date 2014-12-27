package euler

import euler.P039._
import org.scalatest.FunSuite

class T039 extends FunSuite {
  test("there are 3 right triangles with a perimeter of 120") {
    assert(3 == rightTrianglesWithPerimeter(120).size)
  }

  test("1, 1, 1 is a triangle") {
    assert(isTriangle(1, 1, 1))
  }

  test("1, 1, 10 is not a triangle") {
    assert(!isTriangle(1, 1, 10))
  }

  test("1, 1, 1 is not a right triangle") {
    assert(!isRightTriangle(1, 1, 1))
  }

  test("the following are right triangles") {
    assert(isRightTriangle(3, 4, 5))
    assert(isRightTriangle(20, 48, 52))
    assert(isRightTriangle(24, 45, 51))
    assert(isRightTriangle(30, 40, 50))
  }
}
