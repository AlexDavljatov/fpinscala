package ch2

import scala.annotation.tailrec

/**
  * @author adavliatov
  * @since 20.04.2017
  */
object Exercise {
  //ex2_1
  def fib(n: Int): Int = {
    @tailrec
    def go(m: Int, f0: Int, f1: Int): Int = {
      if (m == n) f0
      else go(m + 1, f1, f0 + f1)
    }

    go(0, 0, 1)
  }

  //ex2_2
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def loop(n: Int): Boolean = {
      if (n + 1 >= as.length) true
      else if (ordered(as(n), as(n + 1))) loop(n + 1)
      else false
    }

    loop(0)
  }

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = f(a, _)

  //  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = b => f(a, b)
  //  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = (b: B) => f(a, b)

  //ex2_3 - curry
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => b => f(a, b)

  //ex2_4 - uncurry, NB: A => (B => C) <=> A => B => C (=> associates to the right)
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)

  //ex_2_5 - composition, NB: Scala.compose2: g compose f <=> f andThen g
  def compose[A, B, C](f: B => C, g: A => B): A => C = (a) => f(g(a))

  def main(args: Array[String]): Unit = {
    println(isSorted[Int](Array(1, 2, 3, 1), _ < _))
    println(isSorted[Int](Array(1, 2, 3, 1), (a, b) => a < b))
    println(isSorted(Array(1, 2, 3, 1), (a: Int, b: Int) => a < b))
  }
}
