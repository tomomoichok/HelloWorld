package mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MysqlConnect {
//	   // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";

//     MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db?useSSL=false&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456789";

    public static void main(String[] args) {
    	Connection conn = null;
    	Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            //登入
//            insert(stmt,"11","aa");
            //更新
//            update(stmt,"11","bbb");

            delete(stmt,"11");
            //查询
//            ArrayList dbSelectResult = exeSelectDB(stmt);
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
    /* 查询数据*/
    public static ArrayList exeSelectDB(Statement stmt) {
    	ArrayList result = new ArrayList();
    	try{

            String sql;
            sql = "SELECT id, name FROM test_user";
            System.out.println(" SQL实行前...");
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(" SQL实行后...");
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
            	String id  = rs.getString("id");
                String name = rs.getString("name");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print("\n");
                result.add(id+":"+name);
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
    public static void insert(Statement st,String id,String name){

	    try {
	        String sql = "INSERT INTO test_user(id, name )"
	                + " VALUES ('"+id+"','"+name+"')";  // 插入数据的sql语句
	        System.out.println("sql="+sql);
	        int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数


	    } catch (SQLException e) {
	        System.out.println("插入数据失败" + e.getMessage());
	    }
    }

    /* 更新符合要求的记录，并返回更新的记录数目*/
    public static void update(Statement st,String id,String name) {

        try {
            String sql = "update test_user set name='" +name+"' where id="+id;// 更新数据的sql语句

            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数


        } catch (SQLException e) {
            System.out.println("更新数据失败");
        }
    }
    /* 删除符合要求的记录，并返回删除的记录数目*/
    public static void delete(Statement st,String id) {

        try {
            String sql = "delete from  test_user where id="+id;

            int count = st.executeUpdate(sql);// 执行更新操作的sql语句


        } catch (SQLException e) {
            System.out.println("删除数据失败");
        }
    }

}
