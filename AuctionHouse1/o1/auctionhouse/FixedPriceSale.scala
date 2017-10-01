package o1.auctionhouse
/*
import o1.auctionhouse.FixedPriceSale
val fps1 = new FixedPriceSale("tuote", 52, 6)


 */
class FixedPriceSale(val description: String, val price: Int, private var duration: Int) {
  
  // Privates
  private var expired:Boolean = 0 >= this.duration
  private var bought:Boolean = false
  
  private var buyerName: Option[String] = None
  
  
  // Publics
  def advanceOneDay() = {
    if (!this.expired && !this.bought) {
      this.duration = this.duration - 1
      this.expired = 0 >= this.duration
    }
  }
  
  def buy(buyer: String) = {
    var success = false
    if (!this.expired && !this.bought) {
      this.buyerName = Some(buyer)
      this.bought = true
      success = true
    }
    success
  }
  
  def buyer: Option[String] = this.buyerName

  def daysLeft = this.duration
  
  def isExpired = this.expired
  
  def isOpen = (!this.expired && !this.bought)
  
  override def toString = this.description
  
  
}