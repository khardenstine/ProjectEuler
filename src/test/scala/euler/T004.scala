package euler

import org.scalatest.FunSuite

class T004 extends FunSuite{
	implicit def int2str(i: Int): String = i.toString

	test("racecar, 9009 and 424 are palindromes") {
		assert(P004.isPalindrome("racecar"))
		assert(P004.isPalindrome(9009))
		assert(P004.isPalindrome(424))
	}

	test("asdf, 9019, and 12345 are not palindromes") {
		assert(!P004.isPalindrome("asdf"))
		assert(!P004.isPalindrome(9019))
		assert(!P004.isPalindrome(12345))
	}
}
