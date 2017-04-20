import ch3._

var ex1: List[Double] = Nil
var ex2: List[Int] = Cons(1, Nil)
var ex3: List[String] = Cons("a", Cons("b", Nil))
List sum ex2
var ex4: List[Int] = List(1, 2, 3)

val w = List(1, 2, 3, 4, 5) match {
  case Cons(x, Cons(2, Cons(4, _))) => x
  case Nil => 42
  case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
  case Cons(h, t) => h + List.sum(t)
  case _ => 101
}