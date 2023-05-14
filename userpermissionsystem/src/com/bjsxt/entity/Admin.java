package com.bjsxt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;


public class Admin implements Serializable,HttpSessionBindingListener,HttpSessionActivationListener{
	

	private  String  userid;
	  
	private  String  username;
	
	private  String  password;
	
	private  int  age;
	
	private  float  score;
	
	private  Date  enterdate;
	
	private  String  hobby;
	
	
	public Admin(){
		
		
	}
	
	public Admin(String userid, String username, String password, int age,
			float score, Date enterdate, String hobby) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.age = age;
		this.score = score;
		this.enterdate = enterdate;
		this.hobby = hobby;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Date getEnterdate() {
		return enterdate;
	}

	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Admin [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", age=" + age + ", score="
				+ score + ", enterdate=" + enterdate + ", hobby=" + hobby + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		//HttpSessionBindingListener  监听的是具体的对象    不需要再web.xml中配置
	  System.out.println("Admin.valueBound()");
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		
		/**
		 *  req.getSession().invalidate();
		    
		    req.getSession().removeAttribute("admin");
		 * */
		System.out.println("Admin.valueUnbound()");
		
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Admin.sessionDidActivate()");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Admin.sessionWillPassivate()");
	}	
	
}
