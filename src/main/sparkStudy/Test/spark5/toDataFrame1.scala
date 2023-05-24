package Test.spark5

import org.apache.spark.sql.SparkSession

object toDataFrame1 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("sparkSQL").master("local[*]").getOrCreate()
    val data = spark.sparkContext.textFile("./data/movies.dat").map(x => x.split("::"))
    // 缺少.toDF()函数导入 .implicits._ 模块
    import spark.implicits._
    case class Movie(MovieId: Int, Title: String, Genres: String)
    //val res = data.map(x => Movie(x(0).trim.toInt, x(1), x(2))).toDF()
    // trim 去除两边空格，然后转换整型
    //res.show(numRows = 5, truncate = false) // truncate 截断，删节
  }
}
