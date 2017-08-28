object Euler033 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
        |
        |We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
        |
        |There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
        |
        |If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
      """.stripMargin)


    println(s"solution: $solution")
  }

  def solution = {

  }

  def greaterCommonDivisor(a: Long, b: Long): Long = {
    if (b == 0) {
      a
    } else {
      greaterCommonDivisor(b, a % b)
    }
  }

  def multiplyFractions(a: (Long, Long), b: (Long, Long)): (Long, Long) = (a._1 * b._1, a._2 * b._2)

  def simplifyFraction(a: (Long, Long)): (Long, Long) = {
    val gcd = greaterCommonDivisor(a._1, a._2)
    (a._1 / gcd, a._2 / gcd)
  }
}
