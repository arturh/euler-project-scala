object Euler030 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
        |
        |1634 = 14 + 64 + 34 + 44
        |8208 = 84 + 24 + 04 + 84
        |9474 = 94 + 44 + 74 + 44
        |As 1 = 14 is not a sum it is not included.
        |
        |The sum of these numbers is 1634 + 8208 + 9474 = 19316.
        |
        |Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution = {
    println(digitsToCheck)
    println(largestNumberWithNumberOfDigits(digitsToCheck))
    (BigInt(10) to largestNumberWithNumberOfDigits(digitsToCheck))
      .filter { (n: BigInt) => n == sumOfFifthPowerOfDigits(n) }
      .sum

  }

  def sumOfFifthPowerOfDigits(n: BigInt) = n.toString.split("").map { (digit) => BigInt(digit.toInt).pow(5) }.sum

  def upperBoundForSumOfFifthPowerOfDigitsForNumberWithNumberOfDigits(numberOfDigits: Long): BigInt = {
    BigInt(numberOfDigits) * BigInt(9).pow(5)
  }
  def largestNumberWithNumberOfDigits(numberOfDigits: Int) = BigInt(10).pow(numberOfDigits) - 1

  def digitsToCheck: Int = {

    Stream
      .from(1)
      .map { (n) => (n, upperBoundForSumOfFifthPowerOfDigitsForNumberWithNumberOfDigits(n), largestNumberWithNumberOfDigits(n)) }
      .dropWhile { case (n, upperBound, largestNumber) => upperBound > largestNumber }
      .head
      ._1

  }

}
