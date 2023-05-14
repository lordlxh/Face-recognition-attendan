package com.bjsxt.entity;
 
import java.io.Serializable;  
import java.util.Date; 



public class User implements Serializable{
    private String Uid;
	private String Uname;
    private String pwd;
    private String sfz;
    private String phone;
    private String photoname;
    
	public User() {
		super();
	}
	
    
	public User(String Uid,String Uname,String pwd,String sfz,String phone,String photoname) {
		super();
		this.Uid = Uid;
		this.Uname = Uname;
		this.pwd = pwd;
		this.sfz = sfz;
		this.phone = phone;
	    this.photoname =photoname;
	}
	public String getUid() {
		return Uid;
	}

	public void setUid(String Uid) {
		this.Uid = Uid;
	}



	public String getUname() {
		return Uname;
	}

	public void setUname(String Uname) {
		this.Uname = Uname;
	}

	public String getpwd() {
		return pwd;
	}
	public void setpwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getsfz() {
		return sfz;
	}
	public void setsfz(String sfz) {
		this.sfz = sfz;
	}	
	
	public String getphone() {
		return phone;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}
	
	public String getphotoname() {
		return photoname;
	}
	public void setphotoname(String photoname) {
		this.photoname = photoname;
	}
	@Override
	public String toString() {
		return "User [Uid="+Uid+",Uname="+Uname+",pwd="+pwd+",sfz="+sfz+",phone="+phone+ "]";
	}

    
}
