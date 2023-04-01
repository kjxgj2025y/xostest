package org.xos.practice_2

object Scala_3_3 {
  def checkData(data: List[Int]): Unit = data match {
    case data if data.head % 2 == 0 => println("头部为偶数的列表")
    case data if data.head == data.last && data(1) != data.last => println("头尾相等的列表")
    // 3位数俱乐部
    case data if data.head.toString.length == 3 && data.last.toString.length == 3 && data(1).toString.length == 3 => println("3位数俱乐部")
    case _ => println("一般列表")
  }

  def main(args: Array[String]): Unit = {
    // 头部为偶数的列表
    checkData(List(4, 1, 5))
    // 头尾相等的列表（列表元素个数要大于2）
    checkData(List(5, 1, 5, 5))
    // 3位数俱乐部
    checkData(List(123, 321, 413))
    // 其他情况
    checkData(List(9, 1, 6))
  }
}
