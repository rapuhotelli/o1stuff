package o1.auctionhouse

class DutchAuction2(val description: String, val startingPrice: Int, val decrement: Int, val minimumPrice: Int) {


  private var currentPrice:Double = this.startingPrice
  private var stagnation = 0
  private var state = "decreasing" 
  private var buyerName: Option[String] = None
  
  private var lowPoint = {
    this.minimumPrice.toDouble / this.startingPrice.toDouble
  }
  
  private def decreasePrice = this.currentPrice -= this.decrement
  
  
  def advanceOneDay() = {   
    if (this.state == "decreasing") {
      if (this.priceRatio > this.lowPoint) { 
        this.decreasePrice
      } else {
        this.state = "stagnant"
      }
      
    } else if (this.state == "stagnant") {
      if (this.stagnation < 3) {
        this.stagnation += 1
      } else {
        this.state = "expired"
      }
    }
  }
  
  def buy(buyer: String): Boolean = {
    if (this.isOpen) {
      this.buyerName = Some(buyer)
      this.state = "bought"
      true
    } else {
      false
    }
  }
  
  def buyer: Option[String] = {
    if (this.state == "bought") {
      this.buyerName
    }
    None
  }
  
  def isExpired: Boolean = {
    this.state == "expired"
  }
  
  def isOpen: Boolean = {
    ((this.state == "decreasing") || (this.state == "stagnant"))
  }
  
  def price: Int = this.currentPrice.toInt
  
  def priceRatio: Double = this.currentPrice / this.startingPrice
  
  
  override def toString = this.description
}