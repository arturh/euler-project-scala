import scala.math.sqrt

object Euler003 {
  def main(args: Array[String]): Unit = {
    println("""
        |The prime factors of 13195 are 5, 7, 13 and 29.
        |
        |What is the largest prime factor of the number 600851475143 ?
    """.stripMargin)
    println(s"solution: ${solution}")
  }

  def solution: Long = {
    val theNumber = 600851475143L
    val maxPossibleFactor = sqrt(theNumber.toDouble).toLong
    def isFactor(x: Long) = theNumber % x == 0
    def isPrime(x: Long): Boolean = {
      for (i <- 2 to sqrt(x).toInt) {
        if (x % i == 0) return false
      }
      true
    }

    (2L to maxPossibleFactor)
      .filter(isFactor)
      .filter(isPrime)
      .last
  }

}
