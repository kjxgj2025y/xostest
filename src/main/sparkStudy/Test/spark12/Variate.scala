package Test.spark12

object Variate {
  def main(args: Array[String]): Unit = {
    // 用推导变量
    var a = 10
    a = 20
    // 指定类型变量
    var b: String = "100"
    println(a, b, "1")

    // var定义可变变量，val定义不可变变量
    var c: String = "Agui"
    c = "Agui-CCC"
    val d: String = "Aguig"
    // d = "DDD" // val定义不可变变量
    println(c, d, "2")
    // 定义的变量必须赋值
    var e = 10
    var f = "10"
  }
}
