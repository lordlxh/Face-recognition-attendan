package com.bjsxt.service.impl;

import java.util.List; 

import com.bjsxt.entity.Course;
import com.bjsxt.dao.CourseDao;
import com.bjsxt.dao.impl.CourseDaoImpl;

import com.bjsxt.service.CourseService;

public class CourseServiceImpl implements CourseService{
	CourseDao userdao=new CourseDaoImpl();
	public int  CourseRegister(Course Course) {return userdao.insert(Course);}
	@Override
	public List<Course>  CourseFindAll(){return userdao.selectAll();}
	@Override
	 public int CourseRemove(String CourseNo) {return userdao.delete(CourseNo);}
	@Override
	 public Course CourseFindOne(String CourseNo) {return userdao.selectOne(CourseNo);}
	@Override  
	public int CourseChange(Course Course) {return userdao.update(Course);}
	@Override
	 public List<Course> CourseFindLike(String CourseName){return userdao.selectLike(CourseName);}
}
