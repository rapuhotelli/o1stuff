package o1.time

object TimeTest extends App {
  
  val m1 = new Moment(2000)
  val m2 = new Moment(2013)
  
  println("m1: "+m1)
  println("m2: "+m2)
  
  println("m1 distance to m2: "+ m1.distance(m2))
  println("m2 distance to m1: "+ m2.distance(m1))
  
  println("m1 islaterthan m2: "+ m1.isLaterThan(m2))
  println("m2 islaterthan m1: "+ m2.isLaterThan(m1))
  
  println("m1 later than m2: "+ m1.later(m2))
  println("m1 earlier than m2: "+ m1.earlier(m2))
  
  val i1 = new Interval(m1, m2)
  val i2 = new Interval(new Moment(2001), new Moment(2001))
  val i3 = new Interval(new Moment(2002), new Moment(2061))
  
  println("i1 tostring: "+i1)
  println("i2 tostring: "+i2)
  println("i3 tostring: "+i3)
  
  println("Interval 2001-2001 is later than 1990: "+i2.isLaterThan(new Moment(1990)))
  println("Interval 2001-2001 is later than 2009: "+i2.isLaterThan(new Moment(2009)))
  
  println("False: 2001-2001 is later than 2002-2061 : "+i2.isLaterThan(i3))
  println("True: 2002-2061 is later than 2001-2001: "+i3.isLaterThan(i2))
  
  println("\nInterval containts Moment")
  println("True: 1990-2010 contains 2000:"+ new Interval(new Moment(1990), new Moment(2010)).contains(new Moment(2000)))
  println("True: 2000-2010 contains 2000:"+ new Interval(new Moment(2000), new Moment(2010)).contains(new Moment(2000)))
  println("False: 2000-2010 contains 1990:"+ new Interval(new Moment(2000), new Moment(2010)).contains(new Moment(1990)))
  
  println("\nInterval contains Interval")
  println("True: 2002-2061 contains 2004-2006: "+i3.contains(new Interval(new Moment(2004), new Moment(2006))))
  println("False: 2002-2061 contains 1996-2006: "+i3.contains(new Interval(new Moment(1996), new Moment(2006))))
  println("False: 2000-2004 contains 2004-2006: "+new Interval(new Moment(2000), new Moment(2004)).contains(new Interval(new Moment(2004), new Moment(2006))))
  println("False: 2000-2004 contains 2005-2006: "+new Interval(new Moment(2000), new Moment(2004)).contains(new Interval(new Moment(2005), new Moment(2006))))
  
  println("\nMoment isIn Interval")
  println("True: 2004 is in 2002-2061: "+new Moment(2004).isIn(new Interval(new Moment(2002), new Moment(2061))))
  println("True: 2002 is in 2002-2061: "+new Moment(2002).isIn(new Interval(new Moment(2002), new Moment(2061))))
  println("False: 2075 is in 2002-2061: "+new Moment(2075).isIn(new Interval(new Moment(2002), new Moment(2061))))
  println("False: 1999 is in 2002-2061: "+new Moment(1999).isIn(new Interval(new Moment(2002), new Moment(2061))))
  
  println("\nInterval overlaps Interval")
  println("True: 2000-2004 overlaps 1999-2002: "+new Interval(new Moment(2000), new Moment(2004)).overlaps(new Interval(new Moment(1999), new Moment(2002))))
  println("True: 2000-2004 overlaps 2004-2006: "+new Interval(new Moment(2000), new Moment(2004)).overlaps(new Interval(new Moment(2004), new Moment(2006))))
  println("False: 1990-2000 overlaps 2004-2006: "+new Interval(new Moment(1990), new Moment(2000)).overlaps(new Interval(new Moment(2004), new Moment(2006))))
  println("False: 2000-2004 overlaps 2005-2006: "+new Interval(new Moment(2000), new Moment(2004)).overlaps(new Interval(new Moment(2005), new Moment(2006))))
  
  println("\n")
  //println(i3.union(i2))
  println("Union should be 1995-2002: "+new Interval(new Moment(1995), new Moment(2001)).union(new Interval(new Moment(1996), new Moment(2002))))

  println("\n")
  println("Intersection should be 1995-2000: "+ new Interval(new Moment(1980), new Moment(2000)).intersection(new Interval(new Moment(1995), new Moment(2005))))
  
  println("\nLater Than")
  println("True: 2006 is later than 2001-2005: "+ new Moment(2006).isLaterThan(new Interval(new Moment(2001), new Moment(2005))))
  println("False: 2004 is later than 2001-2005: "+ new Moment(2004).isLaterThan(new Interval(new Moment(2001), new Moment(2005))))
  
  println("\nInterval later than")
  println("True: 1902-1989 is later than 1884-1893: "+ new Interval(new Moment(1902), new Moment(1989)).isLaterThan(new Interval(new Moment(1884), new Moment(1893))))
  println("False: 1902-1989 is later than 1893-1902: "+ new Interval(new Moment(1902), new Moment(1989)).isLaterThan(new Interval(new Moment(1893), new Moment(1902))))
      
  println("\nErrors")
  println("False: 1937-2008 contains 1946-2017: "+ new Interval(new Moment(1937), new Moment(2008)).contains(new Interval(new Moment(1946), new Moment(2017))))
  println("False: 1918-2002 contains 1913-2002: "+ new Interval(new Moment(1918), new Moment(2002)).contains(new Interval(new Moment(1913), new Moment(2002))))
  println("True: 29255 is later than 873-4033: "+new Moment(29255).isLaterThan(new Interval(new Moment(873), new Moment(4033))))
  
  println("\n")
  println("True: "+new Interval(new Moment(1918), new Moment(2002))+" contains "+new Interval(new Moment(1918), new Moment(1923))+": "+ new Interval(new Moment(1918), new Moment(2002)).contains(new Interval(new Moment(1918), new Moment(1923))))
  println("True: 1918-2002 contains 1918-1923: "+ new Interval(new Moment(1918), new Moment(2002)).contains(new Interval(new Moment(1918), new Moment(1923))))
  println("\nInterval overlaps")
  println("True: 1962-1981 overlaps 1971-2003: "+new Interval(new Moment(1962), new Moment(1981)).overlaps(new Interval(new Moment(1971), new Moment(2003))))
  println("False: 1995-2016 overlaps 1975-1982: "+new Interval(new Moment(1975), new Moment(1982)).overlaps(new Interval(new Moment(1995), new Moment(2016))))
  
  
  
}