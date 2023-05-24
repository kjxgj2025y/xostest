package spark.Core

// 错误：NotSerializableException: sparkCore.Task，解决错误：网络传输要对内容进行序列化
class SubTask extends Serializable {
  var data: List[Int] = _
  var logic: Int => Int = _
  def compute2():List[Int] = {
    data.map(logic)
  }
}
