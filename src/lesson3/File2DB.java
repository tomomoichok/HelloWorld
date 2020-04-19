package lesson3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//// 创建数据库
//CREATE DATABASE test CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
//// 创建表
//CREATE TABLE IF NOT EXISTS `employee` (
//	    `id` MEDIUMINT NOT NULL AUTO_INCREMENT,
//	    `username` varchar(100) NOT NULL,
//	    `age` int(3) NOT NULL,
//	    `memo` varchar(100) NOT NULL,
//	    `createtime` DATETIME  NOT NULL,
//	    PRIMARY KEY (id)
//	  ) ENGINE=InnoDB

public class File2DB {
	public static void main(String[] args) {
		String databasename = "test";
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost/" + databasename+"?useUnicode=true&characterEncoding=utf8";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			file2db(conn);
			conn.close();

			System.out.println("DB操作完了");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}


	private static void file2db(Connection conn) throws Exception {

		FileReader fr = null;
		BufferedReader br = null;
		try {
			File f = new File("C:\\pleiades\\temp\\test.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				//todo
				System.out.println(s);
				insert(conn, s);
			}

			br.close();
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}

	private static void insert(Connection conn, String s) throws Exception {
		try {
			String sqlstr = "insert into employee(id,username,age,memo,createtime)"
					+ "values(?,?,?,?,NOW())";
			PreparedStatement ps = conn.prepareStatement(sqlstr);
			String[] params = s.split(",");
			//params=[1,太郎,23,勉強大好き]
			ps.setInt(1, Integer.parseInt(params[0]));
			ps.setString(2, params[1]);
			ps.setInt(3, Integer.parseInt(params[2]));
			ps.setString(4, params[3]);

			ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}

}
