import math.sqrt

object Euler007 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
        |
        |What is the 10 001st prime number?
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution: Int = {
    def isPrime(x: Int): Boolean = {
      for (i <- 2 to sqrt(x).toInt) {
        if (x % i == 0) return false
      }
      true
    }

    Stream
      .from(2)
      .filter(isPrime)
      .drop(10000)
      .head
  }
}
