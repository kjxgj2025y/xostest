package org.agui

object String_Value {
  def main(args: Array[String]): Unit = {
    var a = "10" + 10
    println(a) // string
    var b: String = "10"
    // Int、Float、Double
    println(b.toInt)
    println(b.toFloat)
    println(b.toDouble)
  }
}
