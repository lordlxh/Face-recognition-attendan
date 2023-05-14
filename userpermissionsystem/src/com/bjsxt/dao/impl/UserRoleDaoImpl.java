package com.bjsxt.dao.impl;

import com.bjsxt.entity.UserRole;   
import com.bjsxt.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.UserRoleDao;

public class UserRoleDaoImpl implements UserRoleDao{

	@Override
	public int insert(UserRole  UserRole) {
		
		String  sql="insert  into   auserroleinfo  values(?,?,?)";
		
		Object [] prams={UserRole.getURid(),UserRole.getUid(),UserRole.getRid()};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
	
	@Override
	public List<UserRole> selectAll() {
		
		String  sql="select  *  from  auserroleinfo";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<UserRole>  list=new ArrayList<UserRole>();
		try {
			while(rs.next()){
                 String URid=rs.getString("URid");
                 String Uid=rs.getString("Uid");
				 String Rid= rs.getString("Rid");
	
				 UserRole userrole=new  UserRole(URid,Uid,Rid);
				list.add(userrole);
			
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
	public int delete(String URid) {
		
		String  sql="delete  from  auserroleinfo  where  URid=?";
		
		Object [] prams={URid};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}

	@Override
	public UserRole selectOne(String URid) {
		
		String  sql="select  *  from auserroleinfo  where URid=?";
		
		Object  [] prams={URid};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		UserRole userrole=null;
		try {
			while(rs.next()){
				String  URid1=rs.getString("URid");
				String  Uid=rs.getString("Uid");
				String  Rid=rs.getString("Rid");

			    userrole=new  UserRole(URid,Uid,Rid);;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return userrole;
	}
	@Override
	public int update(UserRole userrole) {
		
		  String  sql="update  auserroleinfo set Uid=?,Rid=? Where URid=?";
		  
		  Object [] prams={userrole.getUid(),userrole.getRid(),userrole.getURid()};
		 
		  int  update=DBUtil.executeUpdate(sql, prams);
		
		  DBUtil.closeAll();
		   
		return  update;
	}
	@Override
	public List<UserRole> selectLike(String URid) {
		
		String  sql="select  *  from  auserroleinfo  where URid=?";

		Object [] prams={URid};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<UserRole>  list=new  ArrayList<UserRole>();
		try {
			while(rs.next()){
				String URid1=rs.getString("URid");
                 String Uid=rs.getString("Uid");
 
				 String Rid=rs.getString("Rid");
				
				UserRole  userrole=new  UserRole(URid,Uid,Rid);
			   
				list.add(userrole);
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
