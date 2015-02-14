package euler

class P004 extends Problem {
  def computeAnswer() = {
    val threeDigits = 100 to 999
    val productMap = threeDigits.map(num => threeDigits.map(_ * num)) // list of lists
    productMap.flatten // one list
      .sorted.reverse // largest to smallest
      .find(n => P004.isPalindrome(n.toString))
      .get // get an answer or die trying
  }
}

object P004 {
  def isPalindrome(s: String): Boolean = s.reverse == s
}
