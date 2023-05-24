package Test.spark12

object TypeChange {
  def main(args: Array[String]): Unit = {
    // (byte、short)和 char类型不能互相转换
    var a: Byte = 10
    var b: Short = a
    // var c: Char = a // 不能
    // var d: Char = b // 不能
    // byte、short、char、互相计算

  }
}
