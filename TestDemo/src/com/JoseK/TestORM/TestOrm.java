package com.JoseK.TestORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TestOrm {

	public static void main(String[] args) {
		
		//Object[] objs = new Object[3];
		List<Object[]> lists = new ArrayList<Object[]>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getMySQLConn();
			String sql = "select * from Emp where id > 3";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Object[] objs = new Object[3];
				objs[0] = rs.getString("Name");
				objs[1] = rs.getDouble("Salary");
				objs[2] = rs.getDate("HireDate");
				lists.add(objs);
			}
			for(Object[] temp:lists){
				System.out.println("Name:"+temp[0]+"--"+"Salary:"+temp[1]+"--"+"Date:"+temp[2]);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, con);
		}
		
		
		
	}

}
