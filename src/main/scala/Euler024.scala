
object Euler024 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
        |
        |012   021   102   120   201   210
        |
        |What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution: String = {
    val digits: List[String] = "0123456789".split("").toList

    permutations(10, digits)
      .drop(1000000)
      .head
      .mkString
  }

  def permutations(size: Int, elements: List[String]): Stream[List[String]] = {
    if (size == 1) {
      return elements.toStream.map {
        List(_)
      }
    }

    elements
      .toStream
      .flatMap {
        (element) =>
          val restOfElements = elements.filter(_ != element)
          val permutationsWithoutElement = permutations(size - 1, restOfElements)
          permutationsWithoutElement.map {
            element :: _
          }
      }
  }

}
