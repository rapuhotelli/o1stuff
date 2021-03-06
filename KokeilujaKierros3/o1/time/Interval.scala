package o1.time

class Interval(val start: Moment, val end: Moment) {
   
  private val startInt = this.start.toString
  
  def length:Int = this.start.distance(this.end)
  
  def isLaterThan(moment: Moment):Boolean = this.start.toString.toInt > moment.toString.toInt
  
  def isLaterThan(another: Interval):Boolean = {
    !this.overlaps(another) && this.start.toString.toInt > another.end.toString.toInt
  }
  

  def contains(moment: Moment):Boolean = {
    (moment.isLaterThan(this.start) || (moment.toString == this.start.toString)) && 
    (this.end.isLaterThan(moment) || (moment.toString == this.end.toString))
  }
   
  // */
  
  def contains(another: Interval):Boolean = {
    (another.start.toString.toInt >= this.start.toString.toInt) &&
    (another.end.toString.toInt <= this.end.toString.toInt)
  }
  
  
  def overlaps(another: Interval) = {
    this.contains(another) ||
    another.contains(this) ||
    this.start.isIn(another) ||
    this.end.isIn(another)
  }
    
  def union(another: Interval) = {
    val uStart: Moment = this.start.earlier(another.start)
    val uEnd: Moment = this.end.later(another.end)
    new Interval(uStart, uEnd)
  }
  
  
  def intersection(another: Interval): Option[Interval] = {
    var isect: Option[Interval] = None
    if (this.overlaps(another)) {
      val uStart: Moment = this.start.later(another.start)
      val uEnd: Moment = this.end.earlier(another.end)
      val newInterval = new Interval(uStart, uEnd)
      isect = Some(newInterval)
    }
    isect
  }
  
  
  override def toString = {
    var result = ""
    if (this.length == 0) {
      result = this.start.toString
    } else {
      val divider = if (this.length > 50) "..." else  "-"*this.length
      result = start.toString+divider+end.toString
    }
    result
  }
  
  
}