package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		// ����Connection����
		Connection conn;
		// ����������
		String driver = "com.mysql.jdbc.Driver";
		// URLָ��Ҫ���ʵ����ݿ���
		String url = "jdbc:mysql://localhost:3306/db_01";
		// MySQL����ʱ���û���
		String user = "me";
		String password = "12345";

		try {
			// 1.������������Java6���ϰ汾����ʡ�ԣ�
			Class.forName(driver);
			// 2.getConnection()����������MySQL���ݿ�
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
				// 3.����statement���������ִ��SQL���
				Statement stmt = conn.createStatement();
				String sql;
				sql = "SELECT * FROM tb_01";
				ResultSet rs = stmt.executeQuery(sql);
				// չ����������ݿ�
				while (rs.next()) {
					// ͨ���ֶμ���
					int id = rs.getInt("id");
					int data = rs.getInt("data");
					// �������
					System.out.print("id:" + id);
					System.out.print(", data:" + data);
					System.out.print("\n");
				}
				// 4.��ɺ�ر�
				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (SQLException e) {
			// ���ݿ�����ʧ���쳣����
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("���ݿ����ݳɹ���ȡ����");
		}
	}

}
