package com.bjsxt.dao.impl;

import com.bjsxt.entity.RoleFunc;    
import com.bjsxt.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.RoleFuncDao;

public class RoleFuncDaoImpl implements RoleFuncDao{

	@Override
	public int insert(RoleFunc  RoleFunc) {
		
		String  sql="insert  into   arolefuncinfo  values(?,?,?)";
		
		Object [] prams={RoleFunc.getRFid(),RoleFunc.getRid(),RoleFunc.getFid()};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
	
	@Override
	public List<RoleFunc> selectAll() {
		
		String  sql="select  *  from  arolefuncinfo";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<RoleFunc>  list=new ArrayList<RoleFunc>();
		try {
			while(rs.next()){
                 String RFid=rs.getString("RFid");
                 String Rid=rs.getString("Rid");
				 String Fid= rs.getString("Fid");
	
				 RoleFunc userrole=new  RoleFunc(RFid,Rid,Fid);
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
	public int delete(String RFid) {
		
		String  sql="delete  from  arolefuncinfo  where  RFid=?";
		
		Object [] prams={RFid};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}

	@Override
	public RoleFunc selectOne(String RFid) {
		
		String  sql="select  *  from arolefuncinfo  where RFid=?";
		
		Object  [] prams={RFid};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		RoleFunc userrole=null;
		try {
			while(rs.next()){
				String  RFid1=rs.getString("RFid");
				String  Rid=rs.getString("Rid");
				String  Fid=rs.getString("Fid");

			    userrole=new  RoleFunc(RFid,Rid,Fid);;
				
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
	public int update(RoleFunc userrole) {
		
		  String  sql="update  arolefuncinfo set Rid=?,Fid=? Where RFid=?";
		  
		  Object [] prams={userrole.getRid(),userrole.getFid(),userrole.getRFid()};
		 
		  int  update=DBUtil.executeUpdate(sql, prams);
		
		  DBUtil.closeAll();
		   
		return  update;
	}
	@Override
	public List<RoleFunc> selectLike(String RFid) {
		
		String  sql="select  *  from  arolefuncinfo  where RFid=?";

		Object [] prams={RFid};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<RoleFunc>  list=new  ArrayList<RoleFunc>();
		try {
			while(rs.next()){
				String RFid1=rs.getString("RFid");
                 String Rid=rs.getString("Rid");
 
				 String Fid=rs.getString("Fid");
				
				 RoleFunc  userrole=new  RoleFunc(RFid,Rid,Fid);
			   
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
