package com.JoseK.Testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class TestBatch {

	public static void main(String[] args) {
		
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","fanzhiwei1995921"); 
			
			Statement statement = con.createStatement();
			con.setAutoCommit(false);
			
			for(int i = 0;i < 100; i++){
				statement.addBatch("insert into t_user(username,pwd,regTime) values ('小核弹"+i+"','xiaohedan666',now());");
			}
			
			statement.executeBatch();
			
			
			con.commit();
			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
