package Test.spark12
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object RDD_getData_2 {
  def main(args: Array[String]): Unit = {
    // 建立和 spark 框架的连接
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)

    // 创建数据获取外部数据
    val get_file = sc.textFile("./data/phone.txt")
    val data_split: RDD[String] = get_file.flatMap(_.split(",")) // 数据分割
    val worldGroup = data_split.groupBy(data => data) // 数据分组
    sc.parallelize(List(1,23,3,56,9,12,7)).sortBy(x => x,true).take(3)

    // 4、对分组后的数据进行转换
    val wordToCount = worldGroup.map {
      case (word, list) => { // 编写 word和list变量
        (word, list.size) // 使用元组封装数据("aaa", 1)
      }
    }
    // 5、将转换结果采集->控制它->打印出来
    val arr: Array[(String, Int)] = wordToCount.collect() // collect 聚集
    arr.foreach(println) // 遍历打印每个元素
    // 6、关闭连接
    sc.stop()
  }
}
