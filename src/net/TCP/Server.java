package net.TCP;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		// 1.�������ն˵�Socket����
		// ServerSocket(int port)
		ServerSocket ss = new ServerSocket(12345);
		// 2.�����ͻ������ӡ�����һ����Ӧ��Socket����
		// public Socket accept()
		Socket s = ss.accept(); // ���������ܵ����׽��ֵ����ӡ��˷��������Ӵ���֮ǰһֱ������
		// 3.���������ܵ����׽��ֵ����ӡ��˷��������Ӵ���֮ǰһֱ������
		InputStream is = s.getInputStream();
		byte[] bt = new byte[1024];
		is.read(bt); // ����ʽ����
		String data = new String(bt, 0, bt.length);
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + ":" + data);
		// 4.�ͷ���Դ
		s.close();
		// ss.close(); //�����Ӧ�ùر�
	}

}
