package Test.spark5

import org.apache.spark.sql.SparkSession

object toDataFrame3 {
  def main(args: Array[String]): Unit = {
    // 创建与spark连接
    val spark = SparkSession.builder().appName("sparkSQL").master("local").getOrCreate()
    // 获取本地数据
    val df1 = spark.read.csv("./data/people.csv")
    val df2 = spark.read.json("./data/people.json")
    //df2.show()

    // jdbc连接
    val url = "jdbc:mysql://127.0.0.1:3306/spark"
    val table = spark.read.format("jdbc").options(
      Map("url" -> url,
        "user" -> "root",
        "password" -> "123456",
        "dbtable" -> "stu_info")).load()
    table.select("no","name").show()
  }
}
