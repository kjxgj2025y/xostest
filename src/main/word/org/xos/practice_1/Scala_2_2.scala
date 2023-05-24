package org.xos.practice_1

object Scala_2_2 {
  def main(args: Array[String]): Unit = {
    // 水仙花数
    for (x <- 1 to 1000) {
      val a = x / 100
      val b = x % 100 / 10
      val c = x % 100 % 10
      if ((a * a * a + b * b * b + c * c * c) == x) {
        println("水仙花数：" + x)
      }
    }
  }
}
