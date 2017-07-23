import scala.math.sqrt

object Euler010 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
        |
        |Find the sum of all the primes below two million.
      """.stripMargin)
    println(s"solution: $solution")
  }

  def solution: Long = {
    def isPrime(x: Long): Boolean = {
      for (i <- 2 to sqrt(x).toInt) {
        if (x % i == 0) return false
      }
      true
    }

    Stream
      .from(2)
      .map(_.toLong)
      .filter(isPrime)
      .takeWhile(_ < 2000000)
      .sum
  }
}
