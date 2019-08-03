package com.task1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.task1.model.Task1;

public class Task1DAO 
{
	Connection con;
	PreparedStatement ps;
	
	public Task1DAO()
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
	
	public void insertQuery(Task1 task1Object)
	{
		try 
		{
			ps = con.prepareStatement("insert into task1(knee, hip, spinal, wrist, whiplash) values (?, ?, ?, ?, ?)");
			ps.setInt(1, task1Object.getKnee());
			ps.setInt(2, task1Object.getHip());
			ps.setInt(3, task1Object.getSpinal());
			ps.setInt(4, task1Object.getWrist());
			ps.setInt(5, task1Object.getWhiplash());
			
			ps.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void updateQuery(Task1 task1Object)
	{
		String query = "update task1 set knee = ?, hip = ?, spinal = ?, wrist = ?, whiplash = ? where id = 1";
		try 
		{
			ps = con.prepareStatement(query);
			ps.setInt(1, task1Object.getKnee());
			ps.setInt(2, task1Object.getHip());
			ps.setInt(3, task1Object.getSpinal());
			ps.setInt(4, task1Object.getWrist());
			ps.setInt(5, task1Object.getWhiplash());
			
			ps.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public Task1 selectQuery()
	{
		Task1 task1Object = new Task1();
		String query = "select * from task1 where id = 1";
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next())
			{
				task1Object.setKnee(rs.getInt("knee"));
				task1Object.setHip(rs.getInt("hip"));
				task1Object.setSpinal(rs.getInt("spinal"));
				task1Object.setWrist(rs.getInt("wrist"));
				task1Object.setWhiplash(rs.getInt("whiplash"));
			}
		}
		catch(Exception e)
		{
			
		}
		
		return task1Object;
	}
}
