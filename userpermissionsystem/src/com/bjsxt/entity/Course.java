package com.bjsxt.entity; 
 
import java.io.Serializable;   
import java.util.Date; 



public class Course implements Serializable{
    private String CourseNo;
	private String CourseName;
    private String Credit;
    private String Uid;
    
    
	public Course() {
		super();
	}
	
    
	public Course(String CourseNo,String CourseName,String Credit,String Uid) {
		super();
		this.Uid = Uid;
		this.CourseNo = CourseNo;
		this.CourseName = CourseName;
		this.Credit = Credit;
	
	}
	public String getUid() {
		return Uid;
	}

	public void setUid(String Uid) {
		this.Uid = Uid;
	}

	public String getCourseNo() {
		return CourseNo;
	}

	public void setCourseNo(String CourseNo) {
		this.CourseNo = CourseNo;
	}

	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String CourseName) {
		this.CourseName = CourseName;
	}
	
	public String getCredit() {
		return Credit;
	}
	public void setCredit(String Credit) {
		this.Credit = Credit;
	}	
	
	@Override
	public String toString() {
		return "User [";
	}

    
}
