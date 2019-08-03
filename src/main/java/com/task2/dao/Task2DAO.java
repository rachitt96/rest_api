package com.task2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task2DAO 
{
	Connection con;
	PreparedStatement ps;
	
	public Task2DAO()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/talem","root","root");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void insertQuery(String id, String p1, String p2)
	{
		try 
		{
			ps = con.prepareStatement("insert into task2(id, param1, param2) values (?, ?, ?)");
			ps.setString(1, id);
			ps.setString(2, p1);
			ps.setString(3, p2);
			
			ps.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
}
