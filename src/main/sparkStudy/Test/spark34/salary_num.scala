package Test.spark34

import org.apache.spark.storage.StorageLevel
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext, Partitioner}

class salary_num {
  def salary_num(): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("salary_num")
    val sc = new SparkContext(sparkConf)
    //val get_file = sc.textFile("/data/word.txt") // 读取不存在文件会出错
    val data = sc.parallelize(Range(1, 20),4) // 赖操作
    val KV = data.map(x => (x, 1))
    KV.foreach(print)
//    val rdd1 = data.map(x => x*x) // 赖操作
//    val rdd2 = data.map(x => x+5) // 赖操作
//    println("分区数：" + rdd1.repartition(4).partitions.size)
    //data.saveAsTextFile("./outdata/partiData/") // 默认分区是[范围分区]
  }

  def month_visit(): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("salary_num")
    val sc = new SparkContext(sparkConf)
  }
}

object salary_num {
  def main(args: Array[String]): Unit = {
    new salary_num().salary_num()
    //new salary_num().month_visit()
  }
}
