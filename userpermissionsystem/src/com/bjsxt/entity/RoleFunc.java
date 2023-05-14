package com.bjsxt.entity;
import java.io.Serializable;    
import java.util.Date; 

public class RoleFunc {
	private String RFid;
	private String Rid;
	private String Fid;

    
	public RoleFunc() {
		super();
	}
	
    
	public RoleFunc(String RFid,String Rid,String Fid) {
		super();
		this.RFid = RFid;
		this.Rid = Rid;
		this.Fid = Fid;		
	
	}
	public String getRFid() {
		return RFid;
	}
	public void setRFid(String RFid) {
		this.RFid = RFid;
	}
	
	public String getRid() {
		return Rid;
	}
	public void setRid(String Rid) {
		this.Rid = Rid;
	}
	public String getFid() {
		return Fid;
	}
	public void setFid(String Fid) {
		this.Fid = Fid;
	}
	@Override
	public String toString() {
		return "]";
	}

}
