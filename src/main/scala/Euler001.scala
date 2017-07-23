object Euler001 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
        |
        |Find the sum of all the multiples of 3 or 5 below 1000.
      """.stripMargin)

    println(s"solution: ${solution}")

  }

  def solution: Int = {
    def isMultiple(x: Int, y: Int) = x % y == 0
    def isMultipleOf3Or5(x: Int): Boolean = {
      isMultiple(x, 3) || isMultiple(x, 5)
    }


    (0 to 1000)
      .filter(isMultipleOf3Or5)
      .sum
  }
}
