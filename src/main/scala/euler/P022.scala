package euler

class P022 extends Problem {
  def computeAnswer() = {
    val source = io.Source.fromURL(getClass.getResource("/names.txt"))

    val names: Seq[String] = {
      val _names = collection.mutable.ListBuffer[String]()
      var _name = ""
      source.foreach {
        case ',' => Unit
        case '"' => {
          if (_name.length != 0) {
            _names += _name
            _name = ""
          }
        }
        case c => _name += c
      }
      _names
    }

    P022.sumOfScores(names).toString()
  }
}

object P022 {
  def sumOfScores(seq: Seq[String]): BigInt = {
    seq.sorted.zipWithIndex.foldLeft(BigInt(0)) {
      (sum, zipd) =>
        sum + ((zipd._2 + 1) * getWorth(zipd._1))
    }
  }

  def getWorth(s: String): Int = {
    s.foldLeft(0)(_ + _ - 64)
  }
}
