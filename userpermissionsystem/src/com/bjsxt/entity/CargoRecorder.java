package com.bjsxt.entity;
 
import java.io.Serializable; 
import java.util.Date; 



public class CargoRecorder implements Serializable{
    private String CRname;
    
    private String CRNo;
    
	public CargoRecorder() {
		super();
	}
	
    
	public CargoRecorder(String CRname, String CRNo) {
		super();
		this.CRname = CRname;
		this.CRNo = CRNo;
	
	}
	

	
	public String getCRname() {
		return CRname;
	}

	public void setCRname(String CRname) {
		this.CRname = CRname;
	}



	public String getCRNo() {
		return CRNo;
	}

	public void setSname(String CRNo) {
		this.CRNo = CRNo;
	}

	@Override
	public String toString() {
		return "CargoRecorder [CRname=" + CRname + ",  CRNo=" + CRNo + "]";
	}

    
}
