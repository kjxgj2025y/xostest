package Test.spark12

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val wordCount = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(wordCount)
    val input = args(0)
    val output = args(1)
    val get_data = sc.textFile(input).flatMap(x => x.split(" ")).map(x => (x, 1))
    val wordSort = get_data.reduceByKey((x, y) => x + y).sortBy(x => x._2, ascending = false)
    wordSort.foreach(println)
    wordSort.saveAsTextFile(output)
    sc.stop()
  }
}
