package com.task1.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Task1 
{
	private int id;
	private int knee;
	private int hip;
	private int spinal;
	private int wrist;
	private int whiplash;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getKnee() 
	{
		return knee;
	}
	public void setKnee(int knee) 
	{
		this.knee = knee;
	}
	public int getHip() 
	{
		return hip;
	}
	public void setHip(int hip) 
	{
		this.hip = hip;
	}
	public int getSpinal() 
	{
		return spinal;
	}
	public void setSpinal(int spinal) 
	{
		this.spinal = spinal;
	}
	public int getWrist() 
	{
		return wrist;
	}
	public void setWrist(int wrist) 
	{
		this.wrist = wrist;
	}
	public int getWhiplash() 
	{
		return whiplash;
	}
	public void setWhiplash(int whiplash) 
	{
		this.whiplash = whiplash;
	}
}
