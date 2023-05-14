package com.bjsxt.dao.impl;

import com.bjsxt.entity.Course;    
 
import com.bjsxt.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.CourseDao;

public class CourseDaoImpl implements CourseDao{
	//插入数据
	@Override
	public int insert(Course  Course) {
		
		String  sql="insert  into   acourse  values(?,?,?,?)";
		
		Object [] prams={Course.getCourseNo(),Course.getCourseName(),Course.getCredit(),Course.getUid()};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
//查询所有元组	
	@Override
	public List<Course> selectAll() {
		
		String  sql="select  *  from  acourse";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Course>  list=new ArrayList<Course>();
		try {
			while(rs.next()){
				 
				//用户的信息

				 String CourseNo=rs.getString("CourseNo");
				 String CourseName=rs.getString("CourseName");				 
				 String Credit=rs.getString("Credit");
				 String Uid=rs.getString("Uid"); 
				 Course  course=new  Course(CourseNo,CourseName,Credit,Uid);
				list.add(course);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return list;
	}
//删除
	@Override
	public int delete(String CourseNo) {
		
		String  sql="delete  from  acourse  where  CourseNo=?";
		
		Object [] prams={CourseNo};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
//按Uid选择，为更新做铺垫
	@Override
	public Course selectOne(String CourseNo) {
		
		String  sql="select  *  from acourse  where CourseNo=?";
		
		Object  [] prams={CourseNo};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		Course course=null;
		try {
			while(rs.next()){
				String CourseNo1=rs.getString("CourseNo");
				 String CourseName=rs.getString("CourseName");				 
				 String Credit=rs.getString("Credit");
				 String Uid=rs.getString("Uid"); 
				 course=new  Course(CourseNo1,CourseName,Credit,Uid);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return course;
	}
//更新
	@Override
	public int update(Course Course) {
		
		  String  sql="update  acourse set CourseName=?,Credit=?,Uid=? Where CourseNo=?";
		  
		  Object [] prams={Course.getCourseName(),Course.getCredit(),Course.getUid(),Course.getCourseNo()};
		 
		  int  update=DBUtil.executeUpdate(sql, prams);
		
		  DBUtil.closeAll();
		   
		return  update;
	}
//按用户名查询
	@Override
	public List<Course> selectLike(String CourseName) {
		
		String  sql="select  *  from  acourse  where CourseName=?";

		Object [] prams={CourseName};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Course>  list=new  ArrayList<Course>();
		try {
			while(rs.next()){
				 String CourseNo=rs.getString("CourseNo");
				 String CourseName1=rs.getString("CourseName");				 
				 String Credit=rs.getString("Credit");
				 String Uid=rs.getString("Uid"); 
				 Course  course=new  Course(CourseNo,CourseName1,Credit,Uid);
				list.add(course);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return list;
	}

}
