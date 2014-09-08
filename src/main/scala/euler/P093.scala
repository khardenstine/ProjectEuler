package euler

import P093._

class P093 extends Problem {
	def computeAnswer() = {
	  getDigitSetsLessThan(10).maxBy(calculateConsecutiveExpressibleNumbers).mkString
	}
}

object P093 {
  def getDigitSetsLessThan(i: Int) = for (
    d <- 4 until i;
    c <- 3 until d;
    b <- 2 until c;
    a <- 1 until b
  ) yield Set(a, b, c, d)

  final val ALL_OPS = Set(Add, Subtract, Multiply, Divide)

  // given a set of numbers, compute the longest set of consecutive expressible numbers
  def calculateConsecutiveExpressibleNumbers(numbers: Set[Int]): Int = {
    consecutiveLen(getAllComputationCombinations(numbers).flatMap(_.value))
  }

  def consecutiveLen(ints: Iterable[Double]): Int = {
    var lastV = 0

    ints.filter(i => i > 0 && i % 1 == 0).toSeq.sorted.find(i => {
      val intI: Int = (i / 1).toInt
      if (lastV + 1 == intI) {
        lastV = intI
        false
      } else {
        true
      }
    })

    lastV
  }

  /**
   * Any computation of a set of 4 numbers can be structured into a binary tree, e.g.:
   *      Operator(rootOp)
   *      /      \
   * Number(a)  Operator(middleOp)
   *            /     \
   *      Number(b)  Operator(bottomOp)
   *                  /     \
   *            Number(c)  Number(d)
   *
   * @param numbers the set of digits
   * @return all possible binary trees representing the possible computations for the set of digits
   */
  def getAllComputationCombinations(numbers: Set[Int]): Set[Operator] = {
    assert(numbers.size == 4)

    case class Setup(leafA: Leaf, leafB: Leaf, rootOp: (INode, INode) => Operator, middleOp: (INode, INode) => Operator, bottomOp: Operator) {
      def getPermutations: Set[Operator] = {
        val leftRot = middleOp(leafB, bottomOp)
        val rightRot = middleOp(bottomOp, leafB)
        Set(
          rootOp(leafA, leftRot),
          rootOp(leafA, rightRot),
          rootOp(leftRot, leafA),
          rootOp(rightRot, leafA)
        )
      }
    }

    for (
      rootOp <- ALL_OPS;
      middleOp <- ALL_OPS;
      bottomOp <- ALL_OPS;
      a <- numbers;
      b <- numbers.diff(Set(a));
      c <- numbers.diff(Set(a, b));
      d <- numbers.diff(Set(a, b, c));
      rootNode <- Setup(Leaf(a), Leaf(b), rootOp, middleOp, bottomOp(Leaf(c), Leaf(d))).getPermutations
    ) yield rootNode
  }
}

trait INode {
  val value: Option[Double]
}

case class Leaf(leafValue: Double) extends INode {
  val value = Some(leafValue)
  override def toString = leafValue.toString
}

abstract class Operator(left: INode, right: INode) extends INode {
  protected def compute(lValue: Double, rValue: Double): Option[Double]
  val operatorString: String

  val value = for (
    lValue <- left.value;
    rValue <- right.value;
    oValue <- compute(lValue, rValue)
  ) yield oValue

  override def toString = "( %s %s %s )".format(left.toString, operatorString, right.toString)
}

case class Add(left: INode, right: INode) extends Operator(left, right) {
  protected def compute(lValue: Double, rValue: Double) = Some(lValue + rValue)
  val operatorString = "+"
}

case class Subtract(left: INode, right: INode) extends Operator(left, right) {
  protected def compute(lValue: Double, rValue: Double) = Some(lValue - rValue)
  val operatorString = "-"
}

case class Multiply(left: INode, right: INode) extends Operator(left, right) {
  protected def compute(lValue: Double, rValue: Double) = Some(lValue * rValue)
  val operatorString = "*"
}

case class Divide(left: INode, right: INode) extends Operator(left, right) {
  protected def compute(lValue: Double, rValue: Double) = {
    if (rValue != 0)
      Some(lValue / rValue)
    else
      None
  }
  val operatorString = "/"
}
