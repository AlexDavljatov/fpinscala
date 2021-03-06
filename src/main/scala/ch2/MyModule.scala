package ch2

import scala.annotation.tailrec

/**
  * @author adavliatov
  * @since 20.04.2017
  */
object MyModule {
  def abs(n: Int): Int = {
    if (n < 0) -n
    else n
  }

  def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n - 1, n * acc)
    }

    go(n, 1)
  }

  def findFirst[A](as: Array[A], p: A => Boolean): Int = {
    @tailrec
    def loop(n: Int): Int = {
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)
    }

    loop(0)
  }

  private def formatAbs(x: Int) = formatResult("absolute value", x, abs)

  private def formatFactorial(x: Int) = formatResult("factorial", x, factorial)

  private def formatResult(name: String, n: Int, f: Int => Int) = "The %s of %d is %d" format(name, n, f(n))

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFactorial(6))
  }
}
