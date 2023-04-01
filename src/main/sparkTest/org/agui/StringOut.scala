package org.agui

object StringOut {
  def main(args: Array[String]): Unit = {
    var name = "Agui"
    var age = 18
    println("姓名：" + name + "，" + "年龄：" + age + "\n")
    printf("姓名%s，年龄%d\n", name, age)
    var a =
      """
        |姓名：Aguig
        |年龄：20
        |""".stripMargin
    println(a)
  }
}
