package Test.spark12

class object_s(name: String, age: Int) {
  def printOf():Unit = {
    println(name + " " + age + " " + object_s.salary)
  }
}

// object object_s类，是class object_s的伴生类，所以class object_s类可以引用伴生类的所有对象
object object_s{
  val salary = 10000
  def main(args: Array[String]): Unit = {
    val agui = new object_s("Agui", 18)
    agui.printOf() // 结果输出：Agui 18 10000
  }
}
