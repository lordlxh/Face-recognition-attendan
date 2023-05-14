package com.bjsxt.entity;
import java.io.Serializable;   
import java.util.Date; 

public class UserRole {
	private String URid;
	private String Uid;
	private String Rid;

    
	public UserRole() {
		super();
	}
	
    
	public UserRole(String URid,String Uid,String Rid) {
		super();
		this.URid = URid;
		this.Uid = Uid;
		this.Rid = Rid;		
	
	}
	public String getURid() {
		return URid;
	}
	public void setURid(String URid) {
		this.URid = URid;
	}
	
	public String getUid() {
		return Uid;
	}
	public void setUid(String Uid) {
		this.Uid = Uid;
	}
	public String getRid() {
		return Rid;
	}
	public void setRid(String Rid) {
		this.Rid = Rid;
	}

	@Override
	public String toString() {
		return "]";
	}

}
