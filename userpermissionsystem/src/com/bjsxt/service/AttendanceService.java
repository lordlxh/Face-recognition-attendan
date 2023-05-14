package com.bjsxt.service;
import java.util.List;   

 
import com.bjsxt.entity.Attendance;
import com.bjsxt.entity.User;
public interface AttendanceService {
	  public int  insertAllStudent();
	  public   int   deleteAllStudent();
	  public List<Attendance>  AttendanceFindAll();
	  public int AttendanceRemove(String Uid);
	  public Attendance AttendanceFindOne(String Uid);
	  public int AttendanceChange(Attendance Attendance) ;
	  public List<Attendance> AttendanceFindLike(String attendance);
}
