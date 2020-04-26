package mysql;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MysqlPractice {
//	   // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";

//     MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test1?useSSL=false&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456789";

    public static void main(String[] args) {
    	Connection conn = null;
    	Statement stmt = null;
    	ArrayList<DataBean> dbSelectResult = new ArrayList();
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
//            //登入用户信息
//            insertUser(stmt,"1","大郎","23","勉強大好き");
//	        insertUser(stmt,"2","次郎","22","サッカー大好き");
//	        insertUser(stmt,"3","三郎","20","バスケットボール大好き");
//	        insertStudent(stmt,"1","数学","76");
//	        insertStudent(stmt,"1","理科","67");
//	        insertStudent(stmt,"2","数学","86");
//	        insertStudent(stmt,"2","理科","85");
//	        insertStudent(stmt,"3","数学","95");
//	        insertStudent(stmt,"3","理科","91");

            //查询
            dbSelectResult = exeSelectDB(stmt);
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
        writeFile(dbSelectResult);
//        dbSelectResult.forEach(
//        		(row) -> {
//	        			System.out.println(row.getName());
//	        			System.out.println(row.getFraction());
//        			}
//        		);
        System.out.println("Goodbye!");
    }
    /* 查询数据*/
    public static ArrayList<DataBean> exeSelectDB(Statement stmt) {
    	//java.util.Hashtable<String, String>
    	ArrayList<DataBean> result = new ArrayList();
    	try{

            String sql;
            sql = "select u.name,avg(s.fraction) as  fraction from test_user  u inner join test_student s on u.id = s.id group by u.name order by avg(s.fraction) DESC";
            System.out.println(" SQL实行前...");
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(" SQL实行后...");
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String name = rs.getString("name");
                String fraction = rs.getString("fraction");
                DataBean row = new DataBean();
                row.setName(name);
                row.setFraction(fraction);
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
    public static void insertUser(Statement st,String id,String name,String age,String hobby){

	    try {
	        String sql = "INSERT INTO test_user(id, name,age, hobby)"
	                + " VALUES ('"+id+"','"+name+"','"+age+"','"+hobby+"')";  // 插入数据的sql语句
	        System.out.println("sql="+sql);
	        int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数


	    } catch (SQLException e) {
	        System.out.println("插入数据失败" + e.getMessage());
	    }
    }

    public static void insertStudent(Statement st,String id,String curriculum,String fraction){

	    try {
	        String sql = "INSERT INTO test_student(id, curriculum,fraction)"
	                + " VALUES ('"+id+"','"+curriculum+"','"+fraction+"')";  // 插入数据的sql语句
	        System.out.println("sql="+sql);
	        int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数


	    } catch (SQLException e) {
	        System.out.println("插入数据失败" + e.getMessage());
	    }
    }

    public static void writeFile(ArrayList<DataBean> dbSelectResult) {
		try {
	    	File f = new File("selectDB.txt");
	        FileOutputStream fop;
			fop = new FileOutputStream(f);
			OutputStreamWriter writer = new OutputStreamWriter(fop, "utf-8");
	        dbSelectResult.forEach(
	        		(row) -> {
		        			System.out.println(row.getName());
		        			System.out.println(row.getFraction());
								try {
									writer.append(row.getName() + "," + row.getFraction());
									writer.append("\r\n");
								} catch (IOException e) {
									// TODO 自動生成された catch ブロック
									e.printStackTrace();
								}
	        			}
	        		);

	        writer.close();
	        fop.close();

		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    }
}
