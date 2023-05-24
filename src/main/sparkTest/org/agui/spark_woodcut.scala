package org.agui

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.io.StdIn

object spark_woodcut {
  def wordCount(filePath: String): Unit = {
    // 建立和spark框架的连接
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)

    // 执行业务操作
    // 1、添加读取文件路径，然后一行一行的读取
    val lines: RDD[String] = sc.textFile(filePath) // 文件路径
    // 2、将数据进行按空格进行分割
    val words: RDD[String] = lines.flatMap(_.split(" "))
    // 3、分组单词
    val worldGroup: RDD[(String, Iterable[String])] = words.groupBy(word => word)
    // 4、对分组后的数据进行转换
    val wordToCount = worldGroup.map {
      case (word, list) => {
        (word, list.size)
      }
    }
    // 5、将转换结果采集->控制它->打印出来
    val arr: Array[(String, Int)] = wordToCount.collect() // collect 聚集
    arr.foreach(println)
    // 6、关闭连接
    sc.stop()
  }

  def main(args: Array[String]): Unit = {
    val filePath = StdIn.readLine()
    wordCount(filePath)
  }
}
