

package o1
object merkkijonoja {
  
  import scala.collection.mutable.Buffer

  // Kirjoita luvun 4.4 tehtävissä pyydetty koodi tähän alle.
  
  def yhtaikaa(notes: Buffer[String], speed: Int) = {
    Buffer(notes.mkString("&"), speed).mkString("/")
  }
  
  def tempo(str: String) = {
    val i = str.indexOf("/")
    if (i >= 0)
      str.drop(i+1).toInt
    else
      120
  }

}  
  
  
