package euler

class P036 extends Problem {
  def computeAnswer() = {
    (0 until 1000000)
      .filter(i =>
        P004.isPalindrome(i.toString) && P004.isPalindrome(Integer.toBinaryString(i))
      )
      .sum
  }
}
