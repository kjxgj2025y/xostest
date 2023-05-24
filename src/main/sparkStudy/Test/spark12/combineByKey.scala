package Test.spark12
import org.apache.spark.{SparkConf, SparkContext}
//import org.apache.spark.rdd.RDD

object combineByKey {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)
    // 工资
    val first = sc.textFile("./data/first_half.csv")
    val second = sc.textFile("./data/second_half.csv")

    // 合并数据
    val all = first.union(second)

    // 过滤
    val sub_all = all.filter(x => x.contains("EmpID") == false)

    // 分割
    val get_index = sub_all.map(x => {
      val data = x.split(",");
      (data(1), data(6).toInt)
    })

    // 聚合
    val con_test = get_index.combineByKey(
      c => (c, 0),
      (c1: (Int, Int), c2) => (c1._1 + c2, c1._2),
      (c1: (Int, Int), c2: (Int, Int)) => (c1._1 + c2._1, c1._2 + c2._2))

    // 计算每月的薪资
    val avg = con_test.map(x => (x._1, x._2._1.toDouble / 12))

    // 打印
    //avg.foreach(println)

    // 保存
    avg.saveAsTextFile("D:\\ProjectTest\\Scala\\scalaTest\\outdata\\salary_avg")
  }
}
