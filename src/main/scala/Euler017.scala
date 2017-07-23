object Euler017 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
        |
        |If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
        |
        |
        |NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution: Long = {
    (1 to 1000)
      .map(toEnglish)
      .map(_.replace(" ", ""))
      .map(_.length)
      .sum
  }

  def toEnglish(n: Int): String = {
    if (n < 20) {
      underTwenty(n)

    } else if (n < 100) {
      val ones = n % 10
      val tens = n - ones
      val onesInEnglish = if (ones == 0) "" else toEnglish(ones)
      s"${multiplesOfTen(tens)} $onesInEnglish".trim

    } else if (n < 1000) {
      val hundredsDigit = n / 100
      val underAHundred = n % 100
      val underAHundredInEnglish = if (underAHundred == 0)
        ""
      else
        s"and ${toEnglish(underAHundred)}"

      s"${underTwenty(hundredsDigit)} hundred $underAHundredInEnglish".trim

    } else if (n == 1000) {
      "one thousand"

    } else {
      throw new IllegalArgumentException(n.toString)
    }
  }

  private val underTwenty = Map(
    1 -> "one",
    2 -> "two",
    3 -> "three",
    4 -> "four",
    5 -> "five",
    6 -> "six",
    7 -> "seven",
    8 -> "eight",
    9 -> "nine",
    10 -> "ten",
    11 -> "eleven",
    12 -> "twelve",
    13 -> "thirteen",
    14 -> "fourteen",
    15 -> "fifteen",
    16 -> "sixteen",
    17 -> "seventeen",
    18 -> "eighteen",
    19 -> "nineteen"
  )

  private val multiplesOfTen = Map(
    20 -> "twenty",
    30 -> "thirty",
    40 -> "forty",
    50 -> "fifty",
    60 -> "sixty",
    70 -> "seventy",
    80 -> "eighty",
    90 -> "ninety"
  )

}
