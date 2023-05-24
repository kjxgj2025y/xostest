package spark.Core

import java.io.ObjectInputStream
import java.net.ServerSocket

object Executor2 {
  def main(args: Array[String]): Unit = {
    // 启动服务
    println("node2-等待接收")
    val serverSocket = new ServerSocket(8888)
    // 接收数据
    val socket = serverSocket.accept()
    val in = socket.getInputStream
    val inObj = new ObjectInputStream(in)
    // asInstanceOf 数据类型
    val task: SubTask = inObj.readObject().asInstanceOf[SubTask]
    val ints: List[Int] = task.compute2()
    println("node2-接收数据完成：", ints)
    in.close()
    socket.close()
    serverSocket.close()
  }
}
