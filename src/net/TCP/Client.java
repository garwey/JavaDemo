package net.TCP;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		// �������Ͷ˵�Socket����
		// Socket(InetAddress address, int port)
		// Socket(String host, int port)
		// Socket s = new Socket(InetAddress.getByName("192.168.12.92"), 8888);
		Socket s = new Socket("192.168.199.117", 12345);
		// ��ȡ�������д����
		// public OutputStream getOutputStream()
		OutputStream os = s.getOutputStream();
		os.write("Hello?".getBytes());
		// �ͷ���Դ
		s.close();
	}

}
