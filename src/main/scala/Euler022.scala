import scala.io.Source

object Euler022 {
  def main(args: Array[String]): Unit = {
    println(
      """
        |Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
        |
        |For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
        |
        |What is the total of all the name scores in the file?
      """.stripMargin)

    println(s"solution: $solution")
  }

  def solution: Long = {
    names
      .zipWithIndex
      .map({case (name: String, index: Int) => score(name, index)})
      .sum
  }

  val names: Array[String] = Source
    .fromFile("resources/names.txt")
    .mkString
    .split(",")
    .map(_.replace("\"", ""))
    .sorted


  def alphabeticalValue(s: String): Long = {
    s.map(_.charValue().toInt - 'A'.toInt).map(_ + 1).sum
  }

  def score(name: String, index: Int): Long = (index + 1) * alphabeticalValue(name)

}
