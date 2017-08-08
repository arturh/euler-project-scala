object Euler028 {

  def main(args: Array[String]): Unit = {
    println(
      """
        |Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
        |
        |21 22 23 24 25
        |20  7  8  9 10
        |19  6  1  2 11
        |18  5  4  3 12
        |17 16 15 14 13
        |
        |It can be verified that the sum of the numbers on the diagonals is 101.
        |
        |What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution: Long = {
    val spiral = spiralOfSize(1001)

    List(
      diagonalSum(spiral),
      diagonalSum(flipSpiral(spiral)),
      if (spiral.length % 2 == 0) 0 else -1
    ).sum
  }

  def spiralOfSize(n: Int): Array[Array[Long]] = {
    assert(n % 2 == 1)

    val result = Array.ofDim[Long](n, n)

    var x: Int = n / 2
    var y: Int = n / 2

    Stream
      .from(1)
      .flatMap {
        (i) =>
          val j = if (i % 2 == 0) {
            -1
          } else {
            1
          }
          List(
            List.fill(i)((0, j)),
            List.fill(i)((j, 0))
          ).flatten
      }
      .zipWithIndex
      .take(n * n)
      .foreach {
        case ((dx, dy), index) =>
          result(x)(y) = index + 1
          x += dx
          y += dy
      }

    result
  }

  def exampleSpiral(): Array[Array[Long]] = {
    """
      |21 22 23 24 25
      |20  7  8  9 10
      |19  6  1  2 11
      |18  5  4  3 12
      |17 16 15 14 13
    """.stripMargin
      .trim
      .split("\n")
      .map { parseLine }
  }

  def diagonalSum(spiral: Array[Array[Long]]): Long = {
    spiral
      .zipWithIndex
      .map { case (row, index) => row(index) }
      .sum
  }

  def flipSpiral(spiral: Array[Array[Long]]): Array[Array[Long]] = {
    spiral.map { (row) => row.reverse }
  }

  def parseLine(line: String): Array[Long] = {
    line.split("\\s+").map { (item: String) => item.toLong }
  }
}
