package o1.odds

// This class is gradually developed between Chapters 2.4 and 3.1.

class Odds(val wont: Int, val will: Int) {
  
  def probability = 1.0 * this.will / (this.wont + this.will)
  
  def fractional = this.wont + "/" + this.will
  
  def decimal = (1.0*this.wont + 1.0*this.will) / (1.0*this.will)
  
  def winnings(multiplier: Double) = this.decimal*multiplier
  
  def isLikely = this.wont < this.will
  
  def isLikelierThan(another: Odds) = this.probability > another.probability

  def moneyline = {
    if (this.probability <= 0.5)
      100*this.wont/this.will
    else
      -100*this.will/this.wont
  }
}


/*

import o1.odds.Odds
 val nw = new Odds(5, 2)
 val notRollingSix = new Odds(1, 5)


rollingSix.isLikely
notRollingSix.isLikely

val nw = new Odds(5, 2)

 */