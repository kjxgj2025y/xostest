package Test.spark5

import org.apache.spark.sql.SparkSession

object SparkSQL {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local").getOrCreate()

    //val stuDF = spark.read.format("json").load("./data/student.json")
    //stuDF.createOrReplaceTempView("stu")
    //spark.sql("select name,age from stu where age > 20").show
    //stuDF.select("name","age","country").where("country='china'").orderBy("age").show
    //stuDF.where("age=20 and country='china'").write.json("E:\\KJXGJ\\data\\stu_1.json")
    //stuDF.write.format("parquet").mode("Overwrite").save("E:\\KJXGJ\\data\\stu1")
    //stuDF.select("name","age").where("age>20").show()

    val house = spark.read.csv("./data/house.csv")
    val data = house.filter("_c2!='bathroom_num'")
    data.select("_c0").show()
  }
}
