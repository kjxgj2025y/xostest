package Test.spark5

import org.apache.spark.sql.{SparkSession, Row}
import org.apache.spark.sql.types.{StructType, StringType, StructField}

object MovieSQL {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local").getOrCreate()
    val data = spark.sparkContext.textFile("./data/movies.dat").map(_.split("::"))
    val schema = "no name juzhong"
    // 定义字段格式
    //val fieldStruct = StructType(schema.split(" ").map(x => StructField(x, StringType, nullable = true)))
    //val sub_data = data.map(x => Row(x(0), x(1), x(2)))
    //val DF_data = spark.createDataFrame(sub_data, fieldStruct)
    //DF_data.createOrReplaceTempView("movie")
    //val indexMovie = spark.sql("select * from movie where name like'%1996%'")
    //indexMovie.repartition(1).write.mode("Overwrite").format("parquet").save("./outData/indexMovie")
  }
}
