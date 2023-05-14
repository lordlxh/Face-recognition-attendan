package com.bjsxt.dao;

import java.util.List; 

 
import com.bjsxt.entity.Course;
 

public interface CourseDao {;
	public   int   insert(Course  Course);
	public   List<Course> selectAll();
	public int delete(String CourseNo);
	public Course selectOne(String CourseNo);
	public int update(Course course);
	public List<Course> selectLike(String Course);
}
