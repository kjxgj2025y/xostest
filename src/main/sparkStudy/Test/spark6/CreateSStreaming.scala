package Test.spark6

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{StreamingContext, Seconds}

object CreateSStreaming {
  def main(args: Array[String]): Unit = {
    // StreamingContext: spark.master should be set as local[n], n > 1 in local mode if you have receivers to get data
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)
    val ssc = new StreamingContext(sc, Seconds(1))
    val lines = ssc.socketTextStream("127.0.0.1", 5555)
    lines.filter(x => x.contains())
    val sub_data = lines.flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _) // 懒操作
    sub_data.print() // 懒操作
    ssc.start() // 行动操作
    ssc.awaitTermination() // 等待终端
    ssc.awaitTerminationOrTimeout(10000) // 超时设置 10秒
  }
}