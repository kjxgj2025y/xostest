package org.xos.practice_2

import scala.io._

class Scala_3_2 {
  def checkSpark(): Unit = {
    val get_spark = Source.fromFile("./data/spark.txt").mkString.split(" ").toList
    var sum = 0
    for(x <- get_spark){
      if (x == "Spark" || x=="Spark’s"){
        sum = sum + 1
      }
    }
    println("Spark单词在文中出现 " + sum + " 次")
  }
}

object Scala_3_2 {
  def main(args: Array[String]): Unit = {
    new Scala_3_2().checkSpark()
  }
}
