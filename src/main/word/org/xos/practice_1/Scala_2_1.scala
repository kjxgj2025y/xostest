package org.xos.practice_1

import scala.io.Source.fromFile

object Scala_2_1 {

  def isPalindrom(word: String): Unit = {
    // 获取文件
    val get_file = fromFile(word)
    val get_word = get_file.mkString.split(",").toList.flatMap(x => x.split(" "))
    println("回文单词如下：")
    for (i <- 0 to get_word.length - 1) {
      if (get_word(i) == "") {
        //println("null")
      } else if (get_word(i) == get_word(i).reverse) {
        println(get_word(i))
      }
    }
  }

  def main(args: Array[String]): Unit = {
    isPalindrom("./data/word.txt")
  }
}
