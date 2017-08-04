package net.UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
		// 1.�������ն�Socket����
		DatagramSocket ds = new DatagramSocket(10086);
		while (true) {
			// 2.����һ�����ݰ�������������
			byte[] bys = new byte[1024];
			// ����
			int length = bys.length;
			DatagramPacket dp = new DatagramPacket(bys, length);
			// 3.����Socket����Ľ��շ����������ݰ�
			ds.receive(dp); // receive()�����ڽ��յ����ݱ�ǰһֱ����
			// 4.�������ݰ�������ʾ
			InetAddress address = dp.getAddress();
			String ip = address.getHostAddress(); // ��ȡ�Է���ip
			byte[] bys2 = dp.getData(); // ��ȡ���ݻ�����
			int len = dp.getLength(); // ��ȡ���ݵ�ʵ�ʳ���
			String s = new String(bys2, 0, len);
			if (s.equals("exit"))
				break;
			System.out.println(ip + ":" + s);
		}
		// 5.�ͷ���Դ
		// ds.close();
	}
}
