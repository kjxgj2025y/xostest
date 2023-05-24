package Test.spark12

object BooleanValue {
  def main(args: Array[String]): Unit = {
    // Boolean
    var a: Boolean = true
    var b: Boolean = false
    println(a)
    println(b)

    // 数值类型自动转换
    var f1 = 1 + 2.0
    println(f1) // Double

    // 将高精度转换为低精度，会出错
    var f2: Double = 1.0
    var f3: Int = 1
    println(f2 + f3)

    // 其中 byte、short、Char不能自动相互转换，但可以运算(将类型转换为 Int再运算)
    var a1: Byte = 10
    var a2: Short = 20
    var a3: Char = '@' // Char只能装一个字符
    println(a1 + a2 + a3)

    // 强自转换
    var e: Int = 3.999.toInt // 直接不要后面小数点
    println(e)
  }
}
