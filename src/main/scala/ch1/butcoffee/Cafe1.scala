package ch1.butcoffee

/**
  * @author adavliatov
  * @since 19.04.2017
  */
class Cafe1 {
  def buyCoffee(cc: CreditCard, p: Payments): Coffee = {
    val cup = new Coffee()
    p.charge(cc, cup.price)
    cup
  }
}
