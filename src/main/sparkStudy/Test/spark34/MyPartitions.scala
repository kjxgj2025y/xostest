package Test.spark34

import org.apache.spark.{Partitioner, SparkConf, SparkContext}

import scala.io.StdIn

class MyPartitions(numParti: Int) extends Partitioner {
  override def numPartitions: Int = numParti

  override def getPartition(key: Any): Int = {
    if (key.toString.substring(6, 8) == "01") {
      0
    } else if (key.toString.substring(6, 8) == "02") {
      1
    } else {
      2
    }
  }

  override def equals(other: Any): Boolean = other match {
    case myPartitions: MyPartitions => myPartitions.numPartitions == numPartitions
    case _ => false
  }
}

object MyPartitions {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("salary_num")
    val sc = new SparkContext(sparkConf)
    val path = StdIn.readLine().split(" ").toList
    val inputPath = path(0)
    val outputPath = path(1)
    val data = sc.textFile(inputPath).map(x => {
      val y = x.split(","); (y(0), y(1))
    })
    val data2 = data.partitionBy(new MyPartitions(3))
    data2.saveAsTextFile(outputPath)
    // ./data/classData.txt ./outData/classData/
  }
}