object Euler026 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
        |
        |1/2	= 	0.5
        |1/3	= 	0.(3)
        |1/4	= 	0.25
        |1/5	= 	0.2
        |1/6	= 	0.1(6)
        |1/7	= 	0.(142857)
        |1/8	= 	0.125
        |1/9	= 	0.(1)
        |1/10	= 	0.1
        |Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
        |
        |Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution: Long = {
    (2 to 1000)
      .map { (n) => (Euler026.multiplicativeOrder(10, n), n) }
      .max
      ._2
  }

  def greatestCommonDivisor(a: Long, b: Long): Long = {
    if (b == 0) {
      a
    } else {
      greatestCommonDivisor(b, a % b)
    }
  }

  def multiplicativeOrder(a: Long, n: Long): Long = {
    if (greatestCommonDivisor(a, n) > 1) {
      return 0
    }

    var order = 1
    var moduloExponent = a

    while (moduloExponent != 1) {
      order += 1
      moduloExponent = (moduloExponent * a) % n
    }

    order
  }

}
