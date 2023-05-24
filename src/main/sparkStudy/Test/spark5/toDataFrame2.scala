package Test.spark5

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object toDataFrame2 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("sparkSQL").master("local").getOrCreate()
    val data = spark.sparkContext.textFile("./data/classData.txt")
    val schemaString = "stuno,cource,score"
    // schema 格式
    val schema = StructType(schemaString.split(",").map(x => StructField(x, StringType, nullable = true)))
    // RDD 格式
    val rowRDD = data.map(x => x.split(",")).map(x => Row(x(0),x(1),x(2)))
    val res = spark.createDataFrame(rowRDD, schema)
    res.show()
  }
}
