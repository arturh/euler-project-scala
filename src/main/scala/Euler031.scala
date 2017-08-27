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

  def solution: Int = {
    val coinValues: List[Int] = List(1, 2, 5, 10, 20, 50, 100, 200).reverse
    numberOfWaysToMakeChange(200, coinValues)
  }

  def numberOfWaysToMakeChange(target: Int, coinValues: List[Int]): Int = {
    coinValues match {
      case Nil => if (target == 0) {
        1
      } else {
        0
      }
      case coinValue :: rest =>
        (0 to target / coinValue)
          .map {
            (coinQuantity: Int) =>
              val newTarget = target - coinQuantity * coinValue
              numberOfWaysToMakeChange(newTarget, rest)
          }.sum
    }
  }
}
