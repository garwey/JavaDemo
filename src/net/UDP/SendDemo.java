package net.UDP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {

	public static void main(String[] args) throws IOException {
		// 1.�������Ͷ�Socket����
		DatagramSocket ds = new DatagramSocket();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = br.readLine()) != null) {
			// 2.��������,�������ݴ��
			byte[] bys = line.getBytes();
			// ����
			int length = bys.length;
			// IP��ַ����
			InetAddress address = InetAddress.getByName("localhost");
			// �˿�
			int port = 10086;
			DatagramPacket dp = new DatagramPacket(bys, length, address, port);
			// 3.����Socket����ķ��ͷ����������ݰ�
			ds.send(dp);
		}
		// 4.�ͷ���Դ
		ds.close();
	}
}
