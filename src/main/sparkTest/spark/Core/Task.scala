package spark.Core

// 错误：NotSerializableException: sparkCore.Task，解决错误：网络传输要对内容进行序列化
class Task extends Serializable {
  val data = List(1, 2, 3, 4)
  val logic: (Int) => Int = _ + 2
  def compute():List[Int] = {
    data.map(logic)
  }
}
