package euler

import P083._

class P083 extends Problem {
  def computeAnswer() = {
    val source = io.Source.fromURL(getClass.getResource("/p083_matrix.txt"))
    val matrix = source.getLines().map {
      line =>
        line.split(",").map(Integer.parseInt)
    }.toArray

    matrixToGraph(matrix).shortestPath()
  }
}

object P083 {
  def matrixToGraph(matrix: Array[Array[Int]]) = {
    val nodeMatrix = matrix.zipWithIndex.map {
      case (row: Array[Int], y: Int) =>
        row.zipWithIndex.map {
          case (cellValue: Int, x: Int) =>
            new Node(x, y)
        }
    }

    // apply the edges
    matrix.zipWithIndex.map {
      case (row: Array[Int], y: Int) =>
        row.zipWithIndex.map {
          case (cellValue: Int, x: Int) =>
            val edge = Edge(cellValue, nodeMatrix(y)(x))

            if (y - 1 >= 0)
              nodeMatrix(y - 1)(x).addEdge(edge)
            if (y + 1 < matrix.length)
              nodeMatrix(y + 1)(x).addEdge(edge)
            if (x - 1 >= 0)
              nodeMatrix(y)(x - 1).addEdge(edge)
            if (x + 1 < row.length)
              nodeMatrix(y)(x + 1).addEdge(edge)
        }
    }

    // add a starting node
    val edge = Edge(matrix(0)(0), nodeMatrix(0)(0))
    val startNode = new Node(-1, -1).addEdge(edge)

    new Graph(startNode, nodeMatrix.last.last, nodeMatrix.flatten.toList)
  }

  class Graph(startingNode: Node, endingNode: Node, nodeList: Iterable[Node]) {
    def shortestPath(): Option[Int] = {
      startingNode.tentativelyVisit(0)
      startingNode.visit()

      val unvisited: collection.mutable.Buffer[Node] = nodeList.toBuffer

      while (unvisited.nonEmpty) {
        val node = unvisited.minBy(node => node.getDistance.getOrElse(Int.MaxValue))
        node.visit()
        unvisited -= node
      }

      endingNode.getDistance
    }
  }

  case class Edge(weight: Int, toNode: Node)

  class Node(val x: Int, val y: Int) {
    private var visited = false
    private var distance: Option[Int] = None

    def getDistance = distance
    def isVisited = visited

    def visit() = {
      edges.foreach {
        edge =>
          edge.toNode.tentativelyVisit(getDistance.get + edge.weight)
      }
      visited = true
    }

    def tentativelyVisit(newDistance: Int): Int = {
      val currentDistance = getDistance.getOrElse(newDistance)
      if (currentDistance >= newDistance)
        this.distance = Some(newDistance)

      this.distance.get
    }

    val edges = collection.mutable.HashSet[Edge]()

    def addEdge(edge: Edge): this.type = {
      edges += edge
      this
    }
  }
}
