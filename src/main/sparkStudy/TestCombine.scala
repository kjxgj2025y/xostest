import org.apache.spark.{SparkConf, SparkContext}
import shapeless.HList.ListCompat.::

object TestCombine {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)
    val rdd5 = sc.parallelize(List((3, "cat"), (4, "lion"), (6, "turtle"), (5, "sheep"),
      (7, "Agui"), (5, "tiger"), (3, "bee"), (5, "panda")))
    val combine = rdd5.combineByKey(
      data => List(data),
      (acc: List[String], acc2: String) => acc2 :: acc, // 不能这样合并 acc::acc2，因为会造成一个值对应多个键
      (acc: List[String], acc2: List[String]) => acc ::: acc2)

    val combine2 = rdd5.combineByKey(
      data => (data, "1"), // (K,V) => (data, "1")
      // acc._1 + acc2 相同的键合并
      (acc: (String, String), acc2: String) => (acc._1 + acc2, acc._2), // (K,V) => (acc._1 + acc2, acc._2)
      // acc._1 + acc2._1 相同的键合并
      (acc: (String, String), acc2: (String, String)) => (acc._1 + acc2._1, acc._2 + acc2._2)
    )
    combine2.foreach(println)
  }
}
