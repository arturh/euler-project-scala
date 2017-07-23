object Euler004 {
  def main(args: Array[String]): Unit = {
    println("""
      |A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
      |
      |Find the largest palindrome made from the product of two 3-digit numbers.
    """.stripMargin)
    println(s"solution: ${solution}")
  }

  def solution: Int = {
    def threeDigitNumbers = 100 to 999
    def isPalindrome(n: Int) = n.toString == n.toString.reverse

    val palindromeProducts = for (
      x <- threeDigitNumbers;
      y <- threeDigitNumbers;
      product = x * y
      if isPalindrome(product)
    ) yield product

    palindromeProducts.max
  }

}
