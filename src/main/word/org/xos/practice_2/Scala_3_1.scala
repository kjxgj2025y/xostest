package org.xos.practice_2

object Scala_3_1 {
  def checkData(data: List[Int]): Unit = data match {
    case data if data.head == 0 => println("头部为0的列表")
    case data if data.last == 0 => println("尾部为0的列表")
    case data if data(1) == 0 => println("第二个元素为0的列表")
    case _ => println("其他情况")
  }
  def main(args: Array[String]): Unit = {
    // 头部为0的列表
    checkData(List(0,1,2))
    // 尾部为0的列表
    checkData(List(3,1,0))
    // 第二个元素为0的列表
    checkData(List(1,0,2))
    // 其他情况
    checkData(List(1,1,1))
  }
}
