package org.xos.practice_1

import scala.io.StdIn

object Scala_2_3 {
  def get_Num(x: Int): Unit = {
    if (x < 0) {
      val y = x * x + 1
      println(y)
    } else if (x == 0) {
      val y = 2
      println(y)
    } else if (x > 0) {
      val y = 6 * x + 3
      println(y)
    }
  }

  def main(args: Array[String]): Unit = {
    // 使用分支结构实现分段函数程序
    // 获取用户数据
    println("请你输入任意一个整数：")
    val num = StdIn.readInt()
    get_Num(num)
  }
}
