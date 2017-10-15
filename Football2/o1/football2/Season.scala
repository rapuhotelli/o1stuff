package o1.football2

import scala.collection.mutable.Buffer

class Season {
  
  private val matches = Buffer[Match]()
  
  private var biggestDifferenceMatch:Option[Match] = None
  
  def addResult(newResult: Match) = {
    this.matches += newResult
    if (this.biggestDifferenceMatch == None) {
      this.biggestDifferenceMatch = Some(newResult)
    }
    
    if (math.abs(newResult.goalDifference) > math.abs(this.biggestDifferenceMatch.get.goalDifference)) {
      this.biggestDifferenceMatch = Some(newResult)
    }
  }
  
  def biggestWin: Option[Match] = {
    if (this.matches.size > 0)
      this.biggestDifferenceMatch
    else
      None
  }
  
  def latestMatch: Option[Match] = {
    if (this.matches.size > 0)
      Some(this.matches(this.matches.size-1))
    else
      None
  }
  
  def matchNumber(number: Int): Option[Match] = {
    if ((number < this.matches.size) && (number >= 0))
      Some(this.matches(number))
    else
      None
  }
  
  def numberOfMatches: Int = this.matches.size
  
}