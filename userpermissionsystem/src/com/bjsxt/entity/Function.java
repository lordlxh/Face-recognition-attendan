package com.bjsxt.entity;
import java.io.Serializable;   
import java.util.Date; 

public class Function {
	private String Fid;
	private String Fname;

    
	public Function() {
		super();
	}
	
    
	public Function(String Fid,String Fname) {
		super();
		this.Fid = Fid;
		this.Fname = Fname;
		
	
	}
	public String getFid() {
		return Fid;
	}

	public void setFid(String Fid) {
		this.Fid = Fid;
	}



	public String getFname() {
		return Fname;
	}

	public void setFname(String Fname) {
		this.Fname = Fname;
	}

	@Override
	public String toString() {
		return "]";
	}

}
