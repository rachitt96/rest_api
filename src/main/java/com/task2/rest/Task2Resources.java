package com.task2.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.task2.dao.Task2DAO;

@Path("task2")
public class Task2Resources 
{
	@POST
	@Path("insert")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response insertFile(@FormDataParam("file") InputStream fileInputStream, @FormDataParam("file") FormDataContentDisposition fileMetaData)
	{
		String line = null;
		String fields[];
		Task2DAO task2Dao = new Task2DAO();
		System.out.println("in here");
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8))) 
		{
			int lineCount = 0;
			while ((line = bufferedReader.readLine()) != null) 
			{ 
				if(lineCount == 0)
				{
					lineCount ++;
					continue;
				}
				
				fields = line.split(",");
				lineCount ++;
				task2Dao.insertQuery(fields[0], fields[1], fields[2]);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return Response.status(200).build();
	}
}
