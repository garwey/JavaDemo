package net.TCP;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		// 1.创建接收端的Socket对象
		// ServerSocket(int port)
		ServerSocket ss = new ServerSocket(12345);
		// 2.监听客户端连接。返回一个对应的Socket对象
		// public Socket accept()
		Socket s = ss.accept(); // 侦听并接受到此套接字的连接。此方法在连接传入之前一直阻塞。
		// 3.侦听并接受到此套接字的连接。此方法在连接传入之前一直阻塞。
		InputStream is = s.getInputStream();
		byte[] bt = new byte[1024];
		is.read(bt); // 阻塞式方法
		String data = new String(bt, 0, bt.length);
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + ":" + data);
		// 4.释放资源
		s.close();
		// ss.close(); //这个不应该关闭
	}

}
