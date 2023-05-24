package spark.Core

import java.io.ObjectOutputStream
import java.net.Socket

object Driver {
  def main(args: Array[String]): Unit = {
    // 接收服务
    val socket1 = new Socket("localhost", 9999)
    // 接收数据
    val task = new Task()
    val out1 = socket1.getOutputStream
    // 创建对象输出流
    val outObj1 = new ObjectOutputStream(out1)
    val subtask1 = new SubTask()
    subtask1.logic = task.logic
    // 拆分获取前 2个
    subtask1.data = task.data.take(2)
    // 写内容
    outObj1.writeObject(subtask1)
    // 发送数据
    out1.flush()
    out1.close()
    println("发送成功")
    socket1.close()

    // 接收服务
    val socket2 = new Socket("localhost", 8888)
    // 接收数据
    val out2 = socket2.getOutputStream
    // 创建对象输出流
    val outObj2 = new ObjectOutputStream(out2)
    val subtask2 = new SubTask()
    subtask2.logic = task.logic
    // 拆分获取后 2个
    subtask2.data = task.data.takeRight(2)
    // 写内容
    outObj2.writeObject(subtask2)
    // 发送数据
    out2.flush()
    out2.close()
    println("发送成功")
    socket2.close()
  }
}
