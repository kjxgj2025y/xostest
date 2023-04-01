package org.agui

object ArrayTest {
  def main(args: Array[String]): Unit = {
    var arr: Array[String] = Array("aaa", "bbb", "ccc")
    //    println(arr.head)
    //    println(arr.tail)
    //    println(arr.isEmpty)
    //    println(arr.contains("aaa"))
    //    var arr1 = Array(Array.range(1,10,1))
    //    var arr2 = Array(Array.range(1,10,2))
    //    var arr4 = Array(Array.range(1,10,3))
    //    var arr3 = arr1 ++ arr2 ++ arr4
    //    var res = Array.concat(arr1,arr2,arr3)
    //    println(arr3)
    //    println(res)

    var arr1: Array[String] = Array("I am xx,")
    var arr2: Array[String] = Array("I like study.")
    var arr3 = Array.concat(arr1, arr1)
    println(arr3(0) + arr3(1))

    def tests(a: Int, b: Int): Int = {
      return a + b
    }
    //println(tests(10,10))

    def tests02(name: String): String = {
      return name
    }

    printf("%s：Welcome to my Website!", tests02("张飞"))
  }
}
