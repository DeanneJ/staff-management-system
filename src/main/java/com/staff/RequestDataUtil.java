package com.staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RequestDataUtil {
	
	public  List<StaffDetails> getDetails()
	{
		ArrayList <StaffDetails> staff = new ArrayList <>();
		
		String url = "jdbc:mysql://localhost:3306/staff";
		String uname = "root";
		String pwd = "Jaya@123";
		
try {
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pwd);
		Statement stmt = con.createStatement();
		String sql = "select * from staffdetails;";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			 String StaffID = rs.getString(1);
			 String fname = rs.getString(2);
			 String lname = rs.getString(3);
			 String NIC = rs.getString(4);
			 String dob = rs.getString(5);
			 String email = rs.getString(6);
			 String mobile = rs.getString(7);
			 String address = rs.getString(8);
			 String position = rs.getString(9);
			 String department = rs.getString(10);
			 String username = rs.getString(11);
			 String password = rs.getString(12);
			 
			 StaffDetails sd = new StaffDetails(StaffID,fname,lname,NIC,dob,email,mobile,address,position,department,username,password);
			
			 staff.add(sd);
			 
		}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		return staff;
	}
	
	
}
	

