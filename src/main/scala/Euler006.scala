object Euler006 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |The sum of the squares of the first ten natural numbers is,
        |
        |1**2 + 2**2 + ... + 10**2 = 385
        |The square of the sum of the first ten natural numbers is,
        |
        |(1 + 2 + ... + 10)**2 = 552 = 3025
        |Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
        |
        |Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
      """.stripMargin)
    println(s"solution: $solution")
  }

  def solution: Int = {
    val range = 1 to 100
    def square(x: Int) = x * x

    val squareOfTheSum: Int = square(range.sum)
    val sumOfSquares: Int = range.map(square).sum

    squareOfTheSum - sumOfSquares
  }

}
