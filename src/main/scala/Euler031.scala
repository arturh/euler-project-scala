object Euler031 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
        |
        |1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
        |It is possible to make £2 in the following way:
        |
        |1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
        |How many different ways can £2 be made using any number of coins?
      """.stripMargin)

    println(s"solution: $solution")
  }

  val coinValues = Array(1, 2, 5, 10, 20, 50, 100, 200)

  def solution: Int = {
    val targetValue = 200
    var result = 0

    for (a <- 0 to (targetValue / coinValues(0))) {
      val targetValueB = targetValue - a * coinValues(0)
      for (b <- 0 to (targetValueB / coinValues(1))) {

        val targetValueC = targetValueB - b * coinValues(1)
        for (c <- 0 to (targetValueC / coinValues(2))) {

          val targetValueD = targetValueC - c * coinValues(2)
          for (d <- 0 to (targetValueD / coinValues(3))) {

            val targetValueE = targetValueD - d * coinValues(3)
            for (e <- 0 to (targetValueE / coinValues(4))) {

              val targetValueF = targetValueE - e * coinValues(4)
              for (f <- 0 to (targetValue / coinValues(5))) {

                val targetValueG = targetValueF - f * coinValues(5)
                for (g <- 0 to (targetValueG / coinValues(6))) {

                  val targetValueH = targetValueG - g * coinValues(6)
                  for (h <- 0 to (targetValueH / coinValues(7))) {
                    val value =
                      Array(a, b, c, d, e, f, g, h)
                        .zip(coinValues)
                        .map { case (quantity, coinValue) => quantity * coinValue }
                        .sum
                    
                    if (value == targetValue) {
                      println(Array(a, b, c, d, e, f, g, h).mkString(" "))
                      result += 1
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    result
  }
}
