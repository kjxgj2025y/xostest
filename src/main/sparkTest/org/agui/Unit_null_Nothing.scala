package org.agui

object Unit_null_Nothing {
  def main(args: Array[String]): Unit = {
    // Unit
    def Unit_Test(): Unit = {}

    println(Unit_Test)
    // null
    var a = Unit_Test()
    a = null
    // var b: Int = null // an expression of type Null is ineligible for implicit conversion ：var b: Int = null
    println(a)

    // println(b)
    // Nothing
    def nothing_Test(): Nothing = {
      throw new Exception("异常！")
    }

    println(nothing_Test)
  }
}
