package com.JoseK.TestORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCUtil {

	
	public static Connection getMySQLConn(){
		Connection con = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "fanzhiwei1995921");		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return con;
	}
	
	public static void close(ResultSet rs,Statement statement,Connection con){
		
		try {
			if(rs != null){
				rs.close();
			}
			if(statement != null){
				statement.close();
			}
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void close(Statement statement,Connection con){
		
		try {
			if(statement != null){
				statement.close();
			}
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	

	
}
