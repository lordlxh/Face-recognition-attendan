package com.bjsxt.entity;
import java.io.Serializable;  
import java.util.Date; 

public class Role {
	private String Rid;
	private String Rname;

    
	public Role() {
		super();
	}
	
    
	public Role(String Rid,String Rname) {
		super();
		this.Rid = Rid;
		this.Rname = Rname;
		
	
	}
	public String getRid() {
		return Rid;
	}

	public void setRid(String Rid) {
		this.Rid = Rid;
	}



	public String getRname() {
		return Rname;
	}

	public void setRname(String Rname) {
		this.Rname = Rname;
	}

	@Override
	public String toString() {
		return "]";
	}

}
