package net.UDP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {

	public static void main(String[] args) throws IOException {
		// 1.创建发送端Socket对象
		DatagramSocket ds = new DatagramSocket();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = br.readLine()) != null) {
			// 2.创建数据,并把数据打包
			byte[] bys = line.getBytes();
			// 长度
			int length = bys.length;
			// IP地址对象
			InetAddress address = InetAddress.getByName("localhost");
			// 端口
			int port = 10086;
			DatagramPacket dp = new DatagramPacket(bys, length, address, port);
			// 3.调用Socket对象的发送方法发送数据包
			ds.send(dp);
		}
		// 4.释放资源
		ds.close();
	}
}
