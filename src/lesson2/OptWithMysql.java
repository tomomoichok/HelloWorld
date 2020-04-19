package lesson2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OptWithMysql {
	public static void main(String[] args) {
		dowithmysql();
	}

	public static void dowithmysql() {
		String databasename = "test";
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost/" + databasename;
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			//con.setAutoCommit(false);
			Statement st = con.createStatement();
			String sqlStr = "select * from employee";
			ResultSet result = st.executeQuery(sqlStr);
			while (result.next()) {
				System.out.println(result.getString("username"));
			}

			result.close();
			st.close();
			con.close();

			System.out.println("DB操作完了");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
