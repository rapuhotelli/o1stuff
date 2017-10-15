package o1.auctionhouse

object EnglishAuctionTest extends App {
  
  val ea1 = new EnglishAuction("Swag", 50000, 7)  
  println("bidding.."+ea1.bid("Maria", 55000))
  println("price:"+ea1.price)
  
}