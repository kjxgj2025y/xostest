package Test.spark12

import scala.io.StdIn

object KeyInput {
  def main(args: Array[String]): Unit = {
    var a = "请输入你的名字："
    print(a)
    var name = StdIn.readLine()
    var b = "请输入你的年龄："
    print(b)
    var age = StdIn.readInt()
    printf("姓名：%s，年龄：%d", name, age)
  }
}
