import org.apache.spark.{SparkConf, SparkContext}
import scala.io.StdIn

class WordCount {
  def WordCount(path: String): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)
    val get_file = sc.textFile(path).flatMap(x => x.split(" ")).map(x => (x, 1)).reduceByKey((x, y) => x + y)
    val res = get_file.sortBy(x => x._2, false)
    res.foreach(println)
  }
}

object WordCount {
  def main(args: Array[String]): Unit = {
    val path = StdIn.readLine()
    new WordCount().WordCount(path)
  }
}