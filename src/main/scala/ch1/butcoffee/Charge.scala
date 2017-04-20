package ch1.butcoffee

/**
  * @author adavliatov
  * @since 19.04.2017
  */
case class Charge(cc: CreditCard, amount: Int) {
  def combine(other: Charge): Charge =
    if (this.cc == other.cc)
      Charge(cc, amount + other.amount)
    else
      throw new Exception("Can't combine charges to different cards")
}
