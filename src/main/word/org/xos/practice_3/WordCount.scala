package org.xos.practice_3

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val wordCount = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(wordCount)
    val get_data = sc.textFile("./data/word.txt").flatMap(x => x.split(" ")).map(x => (x, 1))
    val w_Count = get_data.reduceByKey((x, y) => x + y).sortBy(x => x._2, ascending = false, numPartitions = 4)
    w_Count.foreach(println)
  }
}
