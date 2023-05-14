package com.bjsxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.bjsxt.dao.AdminDao;
import com.bjsxt.entity.Admin;
import com.bjsxt.util.DBUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin selectOne(String uid, String pwd) {
		
		String  sql="select *  from  t_admin   where  userid=?  and  password=?";
		
		Object [] prams={uid,pwd};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		Admin   admin=null;
		try {
			while(rs.next()){
				
				String userid=rs.getString("userid");
				
				String username=rs.getString("username");
				
				String password=rs.getString("password");
				
				int  age=rs.getInt("age");
				
				float  score=rs.getFloat("score");
				
				Date  enterdate=rs.getDate("enterdate");
				
				String  hobby=rs.getString("hobby");
				
			    admin=new  Admin(userid, username, password, age, score, enterdate, hobby);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
			DBUtil.closeAll();
		}
		
		
		return admin;
	}

	@Override
	public int insert(Admin admin) {
		
		String  sql="insert  into  t_admin   values(?,?,?,?,?,?,?)";
		
		Object  []  prams={admin.getUserid(),admin.getUsername(),admin.getPassword(),admin.getAge(),admin.getScore(),admin.getEnterdate(),admin.getHobby()};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		return update;
	}

}
