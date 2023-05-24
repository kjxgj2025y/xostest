package org.agui

object DataType {
  def main(args: Array[String]): Unit = {
    // Int -> Long
    var a = 1234567890
    var b = 1234567890L
    println(a + "\n" + b)
    // Double -> Float
    var c = 2.2345678912f
    var d = 2.2345678912
    println(c + "\n" + d)
    // Char
    var f: Char = 'a'
    var t: Char = '\t'
    println(f + "\n" + t)
  }
}
