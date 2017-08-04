package net.UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
		// 1.创建接收端Socket对象
		DatagramSocket ds = new DatagramSocket(10086);
		while (true) {
			// 2.创建一个数据包（接收容器）
			byte[] bys = new byte[1024];
			// 长度
			int length = bys.length;
			DatagramPacket dp = new DatagramPacket(bys, length);
			// 3.调用Socket对象的接收方法接收数据包
			ds.receive(dp); // receive()方法在接收到数据报前一直阻塞
			// 4.解析数据包，并显示
			InetAddress address = dp.getAddress();
			String ip = address.getHostAddress(); // 获取对方的ip
			byte[] bys2 = dp.getData(); // 获取数据缓冲区
			int len = dp.getLength(); // 获取数据的实际长度
			String s = new String(bys2, 0, len);
			if (s.equals("exit"))
				break;
			System.out.println(ip + ":" + s);
		}
		// 5.释放资源
		// ds.close();
	}
}
