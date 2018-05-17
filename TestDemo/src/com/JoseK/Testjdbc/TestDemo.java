package com.JoseK.Testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TestDemo {

	public static void main(String[] args) {
		
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "fanzhiwei1995921");
//			String sql = "insert into user (userName,passWord,regtime) values ('小核弹','123456',now())";
//			Statement statement  = con.createStatement();
//			statement.execute(sql);
//			con.setAutoCommit(false);
//			Statement statement = con.createStatement();
//			for(int i =0; i < 50; i++){
//				statement.addBatch("insert into user (userName,passWord,regTime) values ('小核弹 "+i+"','123456',now())");
//			}			
//			statement.executeBatch();			
//			con.commit();
			String sql = "delete from user where id = 49";
			Statement statement = con.createStatement();
			statement.execute(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

}
