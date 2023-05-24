package Test.spark34
import org.apache.spark.{SparkConf, SparkContext}
class combine {
  def combine(): Unit ={
    // 创建与spark连接
    val sparkRDD = new SparkConf().setMaster("local").setAppName("SparkRDD")
    val sc = new SparkContext(sparkRDD)
    // 获取文件
    val get_first = sc.textFile("./data/first_half.csv")
    val get_second = sc.textFile("./data/second_half.csv")
    // 数据合并
    val all = get_first.union(get_second)
    val sub_all = all.filter(x => x.contains("EmpID")==false).map(x => {val data = x.split(","); (data(1), data(6).toInt)})
    // 计算员工年薪
    val sum_all = sub_all.reduceByKey((x ,y) => x + y) // 获取相同键的值进行相加
    // 计算月薪工资
    val combine_salary = sum_all.combineByKey(
      count => (count, 0), // (count, 0) => ((Jonathan Spencer,161301),0)
      (acc: (Int, Int), count) => (acc._1 + count, acc._2),
      (acc2: (Int, Int), acc3: (Int, Int)) => (acc2._1 + acc3._1, acc2._2 + acc3._2)
    )
//    val combine_salary2 = sub_all.combineByKey(
//      data => List(data), // List(data) => (Jonathan Spencer,161301) => (Jonathan Spencer,List(78788, 82513))
//      (acc: List[Int], acc2: Int) => acc2::acc,
//      (acc: List[Int], acc2: List[Int]) => acc:::acc2
//    )
    // 封装成(姓名,年薪,月薪)
    val avg_salary = combine_salary.map(x => (x._1, x._2._1, x._2._1.toDouble / 12))
    // 升序排序
    val sort_salary = avg_salary.sortBy(x => x._3, true, 4)
    sort_salary.foreach(println)
    // 保存数据
    //sort_salary.saveAsTextFile("./outdata/combine")
  }
}
object combine{

  def main(args: Array[String]): Unit = {
    new combine().combine()
  }
}