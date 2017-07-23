object Euler016 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |2**15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
        |
        |What is the sum of the digits of the number 2**1000?
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution: Long = {
    val theNumber = BigInt(2).pow(1000)
    val digits = theNumber.toString.split("").map(_.toLong)

    digits.sum
  }
}
