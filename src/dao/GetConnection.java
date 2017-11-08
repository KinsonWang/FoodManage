package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	private	Connection con;
	private	String user = "root";
	private	String pswd = "123123";
	private String className = "com.mysql.jdbc.Driver";
	private	String url = "jdbc:mysql://localhost:3306/food?useUnicode=true&characterEncoding=utf8";
	
	public GetConnection(){
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载数据库失败！");
			e.printStackTrace();
		}
	}
	
	public Connection getCon(){
		try {
			con = DriverManager.getConnection(url,user,pswd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建数据库连接失败！");
			con = null;
			e.printStackTrace();
		}
		return con;
	}
}
