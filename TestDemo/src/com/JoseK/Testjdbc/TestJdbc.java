package com.JoseK.Testjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class TestJdbc {

	public static void main(String[] args) {
		
		
		try {
//			//加载驱动
//			Class.forName("com.mysql.jdbc.Driver");
//			//建立连接
//			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "fanzhiwei1995921");
//			System.out.println(con);
//			
//			Statement statement = con.createStatement();
//			statement.execute("delete from t_user where id = 1");
//			statement.execute("insert into t_user(username,pwd,regTime) values('王五',132456,now())");
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "fanzhiwei1995921");
//			String sql = "insert into t_user(id,username,pwd,regTime) values(?,?,?,?);";
			String sql = "select * from t_user;";
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setObject(1, 1);
//			ps.setObject(2, "小核弹");
//			ps.setObject(3, "xiaohedan520");
//			ps.setObject(4, new Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getObject(2));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
