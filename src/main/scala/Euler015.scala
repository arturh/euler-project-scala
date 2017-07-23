import scala.collection.mutable

object Euler015 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
        |
        |
        |How many such routes are there through a 20×20 grid?
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution: Long = {
    val memoizeMap = mutable.HashMap.empty[(Long, Long),Long]
    memoizeMap((0, 0)) = 1
    def numberOfPaths(x: Long, y: Long): Long = {
      if (!memoizeMap.contains((x, y))) {
        val moveRight = if (x > 0L) numberOfPaths(x - 1, y) else 0
        val moveDown = if (y > 0L) numberOfPaths(x, y - 1) else 0
        memoizeMap((x, y)) = moveRight + moveDown
      }
      memoizeMap((x, y))
    }

    numberOfPaths(20, 20)
  }
}
