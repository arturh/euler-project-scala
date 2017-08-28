object Euler034 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
        |
        |Find the sum of all numbers which are equal to the sum of the factorial of their digits.
        |
        |Note: as 1! = 1 and 2! = 2 are not sums they are not included.
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution: Long = {
    (1L to factorial(9L) * 7L)
      .filter(isCuriousNumber)
      .sum

  }

  def factorial(n: Long): Long = {
    (1L to n).product
  }

  def isCuriousNumber(n: Long): Boolean = {
    val digits = n.toString.map { (d: Char) => d.toString.toLong }
    val factorialOfDigits = digits.map(factorial)
    digits.length > 1 && factorialOfDigits.sum == n
  }
}
