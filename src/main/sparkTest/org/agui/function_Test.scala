package org.agui

object function_Test {
  def main(args: Array[String]): Unit = {
    // 匿名函数调用，通过赋值给一个变量或常量，调用一个变量或常量加上对应参数，来调用该匿名函数。
    var a = (x: Int) => x + x
    //println(a(10))

    val b = (x: Int) => x + x
    //println(b(10))

    var c = (_: Int) + (_: Int)
    //println(c(20,20))

    // 定义识别手机号码函数
    //    if(yidong.contains(x)){
    //      println("这个码号是中国移动")
    //    }else if(liantong.contains(x)){
    //      println("这个码号是中国联通")
    //    }else if(dianxin.contains(x)){
    //      println("这个码号是中国电信")
    //    }else{
    //      println("这个码号不属于我国的")
    //    }

    val yidong: Array[String] = Array("1340", "1341", "151", "152", "181")
    val liantong: Array[String] = Array("130", "131", "132", "155", "156")
    val dianxin: Array[String] = Array("133", "1349", "153", "180", "181")

    def identify(x: String): Unit = {
      // 实现核心思想是：先提取，后用 contains 函数
      if (yidong.contains(x.substring(0, 4)) || yidong.contains(x.substring(0, 3))) {
        println("这个码号是中国移动")
      } else if (liantong.contains(x.substring(0, 4)) || liantong.contains(x.substring(0, 3))) {
        println("这个码号是中国联通")
      } else if (dianxin.contains(x.substring(0, 4)) || dianxin.contains(x.substring(0, 3))) {
        println("这个码号是中国电信")
      } else {
        println("这个码号不属于我国的")
      }
    }
    // identify("13300909151") // 电信
    // 双 for
    //    var sum = 0
    //    for (i <- 1 to 100; if i % 3 == 0; if i % 5 == 0) {
    //      sum += i
    //    }
    //    println(sum)

    // 统计广州电话号码个数
    def count(area: String): Unit = {
      val arr = Array(
        "115036, 1477799, 广东, 广州, 移动, 020, 510000",
        "115033, 1477801, 广东, 东莞, 移动, 0769, 511700",
        "115032, 1477786, 广东, 广州, 移动, 020, 510000")
      var sum = 0
      for (a <- arr; if a.contains(area)) {
        sum += 1
      }
      println(sum)
    }
    //count("广州")

    // 绘图，2n-1
    for (i <- 1 to 10) {

    }
  }
}
