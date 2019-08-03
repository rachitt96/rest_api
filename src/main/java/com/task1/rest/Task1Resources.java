package com.task1.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.task1.dao.Task1DAO;
import com.task1.model.Task1;

@Path("task1")
public class Task1Resources 
{
	Task1DAO task1Dao = new Task1DAO();
	
	
	@POST
	@Path("insertTask")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertData(Task1 task1)
	{
		task1Dao.insertQuery(task1);
		return Response.status(200).build();
	}
	
	@GET
	@Path("getTask")
	@Produces(MediaType.APPLICATION_JSON)
	public Task1 getData()
	{
		Task1 task1Object = task1Dao.selectQuery();
		return task1Object;
	}
	
	@PUT
	@Path("putTask")
	public Response putData(Task1 task1)
	{
		task1Dao.updateQuery(task1);
		return Response.status(200).build();
	}
}
