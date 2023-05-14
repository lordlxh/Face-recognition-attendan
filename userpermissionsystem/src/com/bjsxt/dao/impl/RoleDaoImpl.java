package com.bjsxt.dao.impl;

import com.bjsxt.entity.Role;  
import com.bjsxt.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.RoleDao;

public class RoleDaoImpl implements RoleDao{

	@Override
	public int insert(Role  Role) {
		
		String  sql="insert  into   aroleinfo  values(?,?)";
		
		Object [] prams={Role.getRid(),Role.getRname()};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
	
	@Override
	public List<Role> selectAll() {
		
		String  sql="select  *  from  aroleinfo";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Role>  list=new ArrayList<Role>();
		try {
			while(rs.next()){
				 
			 
			
				 
				 String Rid= rs.getString("Rid");
				 
				 String Rname=rs.getString("Rname");

				
				
				
				
				Role role=new  Role(Rid, Rname);
			   
				 
				
				
				list.add(role);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return list;
	}
	@Override
	public int delete(String Rid) {
		
		String  sql="delete  from  aroleinfo  where  Rid=?";
		
		Object [] prams={Rid};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}

	@Override
	public Role selectOne(String Rid) {
		
		String  sql="select  *  from aroleinfo  where Rid=?";
		
		Object  [] prams={Rid};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		Role role=null;
		try {
			while(rs.next()){
				String  Rid1=rs.getString("Rid");

				String Rname=rs.getString("Rname");
			
			    role=new  Role(Rid, Rname);;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return role;
	}
	@Override
	public int update(Role role) {
		
		  String  sql="update  aroleinfo set Rname=? Where Rid=?";
		  
		  Object [] prams={role.getRname(),role.getRid()};
		 
		  int  update=DBUtil.executeUpdate(sql, prams);
		
		  DBUtil.closeAll();
		   
		return  update;
	}
	@Override
	public List<Role> selectLike(String Rname) {
		
		String  sql="select  *  from  aroleinfo  where Rname=?";

		Object [] prams={Rname};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Role>  list=new  ArrayList<Role>();
		try {
			while(rs.next()){
                 String Rid=rs.getString("Rid");
 
				 String Rname1=rs.getString("Rname");
				
				Role  role=new  Role(Rid, Rname1);
			   
				list.add(role);
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
