package Test.spark6

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext, Partitioner}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import scala.collection.mutable.ListBuffer

class Test {
  // 学习网址： https://blog.csdn.net/tonydz0523/article/details/120635568
  val sparkConf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("RDD")
  val sc = new SparkContext(sparkConf)
  val data = List("java python", "scala python", "java python", "spark python", "python")
  val rdd: RDD[String] = sc.parallelize(data).flatMap(_.split(" "))

  def mapPartition(): Unit = {
    rdd.mapPartitionsWithIndex(f = (index, iterator) => {
      val buffer = new ListBuffer[String]
      while (iterator.hasNext) {
        buffer.append(index + "分区：" + iterator.next())
      }
      buffer.toIterator
    }).foreach(println)
  }

  // 抽样
  def mySample(): Unit = {
    // withReplacement 是否旋回，fraction 样本数
    rdd.sample(withReplacement = false, fraction = 0.5).foreach(println)
  }

  // 并集
  def myUnion(): Unit = {
    rdd.union(sc.parallelize(List("abc", "aaa", "ccc", "ddd"))).foreach(println)
  }

  // 交集
  def myIntersection(): Unit = {
    rdd.intersection(sc.parallelize(List("java", "aaa", "ccc", "ddd"))).foreach(println)
  }

  // 去重
  def myDuplication(): Unit = {
    rdd.distinct().foreach(println)
  }

  // 按键进行分组
  def myGroup(): Unit = {
    val data = List(("java", 1), ("java", 2), ("spark", 1), ("spark", 2), ("scala", 1), ("scala", 2))
    val rdd = sc.parallelize(data, numSlices = 3)
    rdd.groupByKey().map(x => (x._1, x._2.toList)).foreach(println)
  }

  // mapPartitions 函数，但这函数单独在 RDD 每个分区上运行，输入输出类型都是可迭代类型 Iterator[T] => Iterator[U]
  def mapPar(): Unit = {
    val data = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val mapPar = sc.parallelize(data).mapPartitions(iterator => {
      val builder = new ListBuffer[Int]
      while(iterator.hasNext) {
        builder.append(iterator.next())
      }
      builder.toIterator
    })
    mapPar.foreach(println)
  }

  // join
  def myJoin(): Unit = {
    val a = List((1,"a"),(2,"b"),(3,"c"))
    val b = List((1,"d"),(2,"e"),(3,"f"))
    sc.parallelize(a).join(sc.parallelize(b)).foreach(println)
  }

  //
}

object Test {
  def main(args: Array[String]): Unit = {
    new Test().myJoin()
  }
}