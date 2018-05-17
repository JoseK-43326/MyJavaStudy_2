package com.JoseK.Testjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TestTimeAPP {
	
	public static long dateToStr(String str){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(str).getTime();
		} catch (ParseException e) {
			return 0;
		}

		
	}

	public static void main(String[] args) {
		
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立链接
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","fanzhiwei1995921");
			String sql = "select * from TestUser where lastloginTime>? and lastloginTime<?";
			PreparedStatement ps = con.prepareStatement(sql);
			Date start =new Date(dateToStr("1973-03-10"));
			Date end = new Date(dateToStr("1973-03-11"));
			ps.setObject(1, start);
			ps.setObject(2, end);
			ResultSet rs = ps.executeQuery();
			int i =0;
			while(rs.next()){
				i++;
				System.out.println(rs.getTimestamp("lastloginTime"));
			}
			System.out.println(i);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}	

}
