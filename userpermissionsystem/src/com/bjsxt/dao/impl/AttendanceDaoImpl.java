package com.bjsxt.dao.impl;

import com.bjsxt.entity.Attendance;
import com.bjsxt.entity.User;
import com.bjsxt.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.AttendanceDao;

public class AttendanceDaoImpl implements AttendanceDao{	
	//插入空白的学生表
	@Override
	public int insertAllStudent(){
		
		String  sql="insert into attendance(Uid) select auserinfo.Uid from auserinfo,auserroleinfo,aroleinfo where auserinfo.Uid=auserroleinfo.Uid and auserroleinfo.Rid=aroleinfo.Rid and aroleinfo.Rname=\"学生\";";
		Object [] prams={};
		int  update= DBUtil.executeUpdate(sql, prams);
		String  sql1="update attendance set attendance = '未签'";
		Object [] prams1={};
		int  update1= DBUtil.executeUpdate(sql1, prams1);
		DBUtil.closeAll();
		
		return update1;
	}
	@Override
	public int deleteAllStudent(){
		
		String  sql="delete from attendance";
		Object [] prams={};
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
//查询所有元组	
	@Override
	public List<Attendance> selectAll() {
		
		String  sql="select  *  from  attendance";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Attendance>  list=new ArrayList<Attendance>();
		try {
			while(rs.next()){
				 
				//签到的信息
				 String Uid=rs.getString("Uid");
				 String attendance=rs.getString("attendance");
				 String aDate=rs.getString("aDate");				 
				 Attendance  user=new  Attendance(Uid,attendance,aDate);
				list.add(user);
			
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
	public int delete(String Uid) {
		
		String  sql="delete  from  attendance  where  Uid=?";
		
		Object [] prams={Uid};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
//按Uid选择，为更新做铺垫
	@Override
	public Attendance selectOne(String Uid) {
		
		String  sql="select  *  from attendance  where Uid=?";
		
		Object  [] prams={Uid};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		Attendance user=null;
		try {
			while(rs.next()){
				String Uid1=rs.getString("Uid");
				 String attendance=rs.getString("attendance");
				 String aDate=rs.getString("aDate");				 
				 user=new  Attendance(Uid1,attendance,aDate);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return user;
	}
//更新
	@Override
	public int update(Attendance Attendance) {
		
		  String  sql="update  attendance set attendance=?,aDate=? Where Uid=?";
		  
		  Object [] prams={Attendance.getattendance(),Attendance.getaDate(),Attendance.getUid()};
		 
		  int  update=DBUtil.executeUpdate(sql, prams);
		
		  DBUtil.closeAll();
		   
		return  update;
	}
	//查询谁没签到
		@Override
		public List<Attendance> selectLike(String attendance) {
			
			String  sql="select  *  from  attendance  where attendance=?";

			Object [] prams={attendance};
			
			ResultSet rs = DBUtil.executeQuery(sql, prams);
			
			List<Attendance>  list=new  ArrayList<Attendance>();
			try {
				while(rs.next()){
					String Uid1=rs.getString("Uid");
					 String attendance1=rs.getString("attendance");
					 String aDate=rs.getString("aDate");				 
					 Attendance user=new  Attendance(Uid1,attendance1,aDate);
				   
					list.add(user);
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
