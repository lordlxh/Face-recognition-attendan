package com.bjsxt.service;
import java.util.List;  

 
import com.bjsxt.entity.Course;
public interface CourseService {
	  public int  CourseRegister(Course Course);
	  public List<Course>  CourseFindAll();
	  public int CourseRemove(String CourseNo);
	  public Course CourseFindOne(String CourseNo);
	  public int CourseChange(Course Course) ;
	  public List<Course> CourseFindLike(String CourseName);
}
