object Euler027 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |Euler discovered the remarkable quadratic formula:
        |
        |n2+n+41n2+n+41
        |It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤390≤n≤39. However, when n=40,402+40+41=40(40+1)+41n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41n=41,412+41+41 is clearly divisible by 41.
        |
        |The incredible formula n2−79n+1601n2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤790≤n≤79. The product of the coefficients, −79 and 1601, is −126479.
        |
        |Considering quadratics of the form:
        |
        |n2+an+bn2+an+b, where |a|<1000 and |b|≤1000
        |
        |where |n||n| is the modulus/absolute value of nn
        |e.g. |11|=11 and |−4|=4
        |Find the product of the coefficients, aa and bb, for the quadratic expression that produces the maximum number of primes for consecutive values of nn, starting with n=0n=0.
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution: Long = {
    (for (
      a <- -1000L until 1000L;
      b <- -1000L to 1000L
      if isPrime(math.abs(b))
    ) yield (numberOfPrimes(a, b), List(a, b)))
      .maxBy(_._1)
      ._2
      .product
  }

  def isPrime(n: Long): Boolean = {
    (2L until scala.math.sqrt(n).toLong)
      .forall(n % _ != 0)
  }

  def numberOfPrimes(a: Long, b: Long): Long = {
    Stream
      .from(0)
      .map { (n) => n * n + n * a + b }
      .takeWhile((n) => isPrime(math.abs(n)))
      .length

  }
}
