object Euler005 {
  def main(args: Array[String]): Unit = {
    println("""
      |2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
      |
      |What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?""".stripMargin)

    println(s"solution: $solution")
  }

  def solution: Int = {
    def isEvenlyDivisible(x: Int, y: Int): Boolean = x % y == 0

    def isEvenlyDivisibleByAllNumbersFrom1To20(x: Int): Boolean = {
      for (i <- 2 to 20) {
        if (!isEvenlyDivisible(x, i)) return false
      }
      true
    }

    Stream
        .from(1)
        .map(_ * 19 * 17 * 13 * 11 * 7 * 5 * 3 * 2)
        .dropWhile(!isEvenlyDivisibleByAllNumbersFrom1To20(_))
        .head
  }
}
