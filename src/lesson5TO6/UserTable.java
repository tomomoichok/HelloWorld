package com.web.DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.web.Bean.UserBean;



public class UserTable {
    private Connection conn = null;
    private Statement stmt = null;

    public UserTable() {
		dbConnect();
		dbStmt();
	}

	public Connection getConn() {
		return conn;
	}


	public Statement getStmt() {
		return stmt;
	}


	public void setConn(Connection conn) {
		this.conn = conn;
	}


	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}


	public  void dbConnect() {
//	     MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
	    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	    String DB_URL = "jdbc:mysql://localhost:3306/test1?useSSL=false&serverTimezone=UTC";
	    // 数据库的用户名与密码，需要根据自己的设置
	    String USER = "root";
	    String PASS = "123456789";

        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }

	}
	public void dbStmt() {
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public void DBClose() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

    /* 查询数据*/
    public ArrayList<UserBean> exeSelectDB(UserBean whereBean) {
    	//java.util.Hashtable<String, String>
    	ArrayList<UserBean> result = new ArrayList();
    	try{

            String sql;
            sql = "select USER_ID as userId, USERNAME as userName,PASSWORD as password,address ,age,sex from user";
            System.out.println(" SQL实行前...");
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(" SQL实行后...");
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                UserBean row = new UserBean();
                row.setUserName(rs.getString("userName"));
                row.setAddress(rs.getString("address"));
                row.setPassword(rs.getString("password"));
                row.setUserId(rs.getInt("userId"));
                row.setAge(rs.getInt("age"));
                row.setSex(rs.getString("sex"));
                result.add(row);
            }
            // 完成后关闭
            rs.close();

        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    	return result;
    }
    /* 登入数据*/
    public void insertUser(UserBean insertBean){

	    try {
	        String sql = "INSERT INTO user(USERNAME, PASSWORD,address, age,sex)"
	               + " VALUES ('"+insertBean.getUserName()+"','"+insertBean.getPassword()+"','"+insertBean.getAddress()+"','"+insertBean.getAge()+"','"+insertBean.getSex()+"')";  // 插入数据的sql语句
	        System.out.println("sql="+sql);
	        int count = stmt.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数


	    } catch (SQLException e) {
	        System.out.println("插入数据失败" + e.getMessage());
	    }
    }

    public void UpdateUser(UserBean updateBean){

	    try {
	        String sql = "Update user SET USERNAME = '"+updateBean.getUserName()+"' , PASSWORD = '"+updateBean.getPassword()+"', address='"+updateBean.getAddress()+"', age='"+updateBean.getAge()+"', sex='"+updateBean.getSex()+"'"
	                + " WHERE USER_ID='"+updateBean.getUserId()+"'";  // 更新数据的sql语句
	        System.out.println("sql="+sql);
	        int count = stmt.executeUpdate(sql);  // 执行更新操作的sql语句，并返回插入数据的个数


	    } catch (SQLException e) {
	        System.out.println("更新数据失败" + e.getMessage());
	    }
    }
    public void DeleteUser(UserBean delBean){

	    try {
	        String sql = "DELETE FROM user WHERE USER_ID='"+delBean.getUserId()+"'";  // 删除数据的sql语句
	        System.out.println("sql="+sql);
	        int count = getStmt().executeUpdate(sql);  // 执行删除操作的sql语句，并返回插入数据的个数

	    } catch (SQLException e) {
	        System.out.println("删除数据失败" + e.getMessage());
	    }
    }


}
