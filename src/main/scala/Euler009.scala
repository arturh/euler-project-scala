object Euler009 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
        |
        |a2 + b2 = c2
        |For example, 32 + 42 = 9 + 16 = 25 = 52.
        |
        |There exists exactly one Pythagorean triplet for which a + b + c = 1000.
        |Find the product abc.
      """.stripMargin)
    println(s"solution: $solution")
  }

  def solution: (Int, Int, Int) = {
    (for (
      a <- 1 to 1000;
      b <- a + 1 to 1000;
      c <- b + 1 to 1000

      if a + b + c == 1000
      if a * a + b * b == c * c

    ) yield (a, b, c))
      .head
  }
}
