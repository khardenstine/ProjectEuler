package euler

import scala.collection.mutable

class P017 extends Problem {
  def computeAnswer() = {
    (1 to 1000)
      .map(P017.numberToWords)
      .map(P017.filteredStringLength)
      .sum
  }
}

object P017 {
  def filteredStringLength(s: String): Int = {
    s.filter(c => c != '-' && c != ' ').length
  }

  def numberToWords(num: Int): String = {
    if (num > 1000 || num < 1) { sys.error("valid only for numbers from 1 to 1000") }

    val words: mutable.ListBuffer[String] = mutable.ListBuffer()

    val thousands = digitToWord(num / 1000)
    if (thousands.nonEmpty) {
      words += thousands
      words += "thousand"
    }

    val hundreds = digitToWord((num % 1000) / 100)
    val subHundred = digitToWord(num % 100)
    if (hundreds.nonEmpty) {
      words += hundreds
      words += "hundred"
      if (subHundred.nonEmpty) {
        words += "and"
      }
    }
    if (subHundred.nonEmpty) {
      words += subHundred
    }

    words.mkString(" ")
  }

  private def digitToWord(i: Int): String = {
    i match {
      case 0 => ""
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case 4 => "four"
      case 5 => "five"
      case 6 => "six"
      case 7 => "seven"
      case 8 => "eight"
      case 9 => "nine"
      case 10 => "ten"
      case 11 => "eleven"
      case 12 => "twelve"
      case 13 => "thirteen"
      case 14 => "fourteen"
      case 15 => "fifteen"
      case 16 => "sixteen"
      case 17 => "seventeen"
      case 18 => "eighteen"
      case 19 => "nineteen"
      case 20 => "twenty"
      case 30 => "thirty"
      case 40 => "forty"
      case 50 => "fifty"
      case 60 => "sixty"
      case 70 => "seventy"
      case 80 => "eighty"
      case 90 => "ninety"
      case _ => digitToWord(i - (i % 10)) + "-" + digitToWord(i % 10)
    }
  }
}
