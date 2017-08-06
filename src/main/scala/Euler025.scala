object Euler025 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |The Fibonacci sequence is defined by the recurrence relation:
        |
        |Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
        |Hence the first 12 terms will be:
        |
        |F1 = 1
        |F2 = 1
        |F3 = 2
        |F4 = 3
        |F5 = 5
        |F6 = 8
        |F7 = 13
        |F8 = 21
        |F9 = 34
        |F10 = 55
        |F11 = 89
        |F12 = 144
        |The 12th term, F12, is the first term to contain three digits.
        |
        |What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution: Int = {
    fibonacciNumbers
      .zipWithIndex
      .find { case (n: BigInt, index: Int) => n.toString.length > 1000 }
      .get
      ._2

  }

  val fibonacciNumbers: Stream[BigInt] =
    BigInt(0) #::
      BigInt(1) #::
      fibonacciNumbers
        .zip(fibonacciNumbers.tail)
        .map(n => {
          n._1 + n._2
        })
}
