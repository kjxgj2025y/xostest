import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
object RDD_getData_1 {
  def main(args: Array[String]): Unit = {
    // 建立和spark框架的连接
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)
    // 创建数据获取内部数据
    val data = Array(Range(1,11,1))
    val rdd1 = sc.parallelize(data)
    println(rdd1.collect.mkString)
    val sep = Seq((1,Seq("iteblog.com","aaaa.com")),(3,Seq("aaa2.com","bbb2.com")),(3,Seq("aaa3.com","bbb3.com")))
    val iteblog = sc.makeRDD(sep)
    println(iteblog.collect.mkString)
    println(iteblog.partitioner.mkString)
    println(iteblog.partitions.size.toString)
  }
}
