object Euler021 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
        |If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
        |
        |For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
        |
        |Evaluate the sum of all the amicable numbers under 10000.
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution: Long = {
    (1L to 10000L)
      .filter(isAmicableNumber)
      .sum
  }

  def divisorsOf(n: Long): List[Long] = {
    (1L until n).filter(n % _ == 0).toList
  }

  def isAmicableNumber(x: Long): Boolean = {
    val y = divisorsOf(x).sum
    y != x && divisorsOf(y).sum == x
  }
}
