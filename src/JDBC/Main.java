package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		// 声明Connection对象
		Connection conn;
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名
		String url = "jdbc:mysql://localhost:3306/db_01";
		// MySQL配置时的用户名
		String user = "me";
		String password = "12345";

		try {
			// 1.加载驱动程序（Java6以上版本可以省略）
			Class.forName(driver);
			// 2.getConnection()方法，连接MySQL数据库
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
				// 3.创建statement类对象，用来执行SQL语句
				Statement stmt = conn.createStatement();
				String sql;
				sql = "SELECT * FROM tb_01";
				ResultSet rs = stmt.executeQuery(sql);
				// 展开结果集数据库
				while (rs.next()) {
					// 通过字段检索
					int id = rs.getInt("id");
					int data = rs.getInt("data");
					// 输出数据
					System.out.print("id:" + id);
					System.out.print(", data:" + data);
					System.out.print("\n");
				}
				// 4.完成后关闭
				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("数据库数据成功获取！！");
		}
	}

}
