package com.bjsxt.service.impl;

import java.util.List; 

import com.bjsxt.entity.Attendance;
import com.bjsxt.dao.AttendanceDao;
import com.bjsxt.dao.impl.AttendanceDaoImpl;

import com.bjsxt.service.AttendanceService;

public class AttendanceServiceImpl implements AttendanceService{
	AttendanceDao attendancedao=new AttendanceDaoImpl();
	@Override
	public int  insertAllStudent() {return attendancedao.insertAllStudent();}
	@Override
	public List<Attendance>  AttendanceFindAll(){return attendancedao.selectAll();}
	@Override
	public   int   deleteAllStudent() {return attendancedao.deleteAllStudent();}
	@Override
	 public int AttendanceRemove(String Uid){return attendancedao.delete(Uid);}
	@Override
	 public Attendance AttendanceFindOne(String Uid) {return attendancedao.selectOne(Uid);}
	@Override  
	public int AttendanceChange(Attendance Attendance) {return attendancedao.update(Attendance);}
	@Override  
	public List<Attendance> AttendanceFindLike(String attendance){return attendancedao.selectLike(attendance);}

}
