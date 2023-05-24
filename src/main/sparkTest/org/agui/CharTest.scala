package org.agui

import scala.io.StdIn

object CharTest {
  def main(args: Array[String]): Unit = {
    // 因为_也是个方法
    var _: String = "aaa"
    //print(_)

    //反引号变量名
    var `aa`: String = "bbb"
    //print(`aa`)

    //多行字符串优化美观，stripMargin函数
    var name = "Agui"
    var age = 10
    var s =
      s"""
         |name=$name
         |age=${age + 10}
         |""".stripMargin
    println(s)

    // 键盘输入输出
    println("请输入你的姓名、年龄、薪资：")
    var name02 = StdIn.readLine()
    var age02 = StdIn.readInt()
    var salary = StdIn.readDouble()
    printf("姓名：%s，年龄：%d，薪资：%f", name02, age02, salary)
  }
}
