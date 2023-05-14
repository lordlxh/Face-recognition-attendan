package com.bjsxt.entity;
 
import java.io.Serializable;    
import java.util.Date; 



public class Attendance implements Serializable{
    private String Uid;
	private String attendance;
    private String aDate;
    
	public Attendance() {
		super();
	}
	
    
	public Attendance(String Uid,String attendance,String aDate) {
		super();
		this.Uid = Uid;
		this.attendance = attendance;
		this.aDate = aDate;
		
	}
	public String getUid() {
		return Uid;
	}

	public void setUid(String Uid) {
		this.Uid = Uid;
	}

	public String getattendance() {
		return attendance;
	}

	public void setattendance(String attendance) {
		this.attendance = attendance;
	}

	public String getaDate() {
		return aDate;
	}
	public void setpwd(String aDate) {
		this.aDate = aDate;
	}

	@Override
	public String toString() {
		return "User [Uid=";
	}

    
}
