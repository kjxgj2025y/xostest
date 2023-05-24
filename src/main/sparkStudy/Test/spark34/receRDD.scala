package Test.spark34

import org.apache.spark.{Partitioner, SparkConf, SparkContext}

class receRDD(numParti: Int) extends Partitioner {
  override def numPartitions: Int = numParti

  override def getPartition(key: Any): Int = {
    if (key.toString == "2020") {
      0
    } else {
      1
    }
  }

  override def equals(other: Any): Boolean = other match {
    case myPartitions: MyPartitions => myPartitions.numPartitions == numPartitions
    case _ => false
  }
}

object receRDD {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("salary_num")
    val sc = new SparkContext(sparkConf)
    val file = sc.textFile("./data/raceData.csv")
    //val subData = file.map(x => {val y = x.split(",");(y(4).split(" ")(0).split("/")(0),(y(2),y(1),y(5)))})
    val subData = file.map(x => {val y = x.split(","); (y(2),y(1).toInt)})
    // 以用户ID进行分组统计网页访问量最多前3名；reduceByKey -> sortBy -> res
    val sort = subData.reduceByKey((x,y)=>x+y).sortBy(x=>x._2,false)
    sort.take(5).foreach(println)
    //val res = subData.partitionBy(new receRDD(2))
    //res.saveAsTextFile("./outData/partiYear/")
    //println("分区完成")
    sc.stop() // 关闭资源连接
  }
}
