package com.bjsxt.dao;

import java.util.List; 

 
import com.bjsxt.entity.Attendance;
import com.bjsxt.entity.User;
 

public interface AttendanceDao {
	public   int   insertAllStudent();
	public   int   deleteAllStudent();
	public   List<Attendance> selectAll();
	public int delete(String Uid);
	public Attendance selectOne(String Uid);
	public int update(Attendance attendance);
	public List<Attendance> selectLike(String attendance);
}
