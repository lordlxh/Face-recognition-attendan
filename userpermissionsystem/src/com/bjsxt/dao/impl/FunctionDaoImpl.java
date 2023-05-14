package com.bjsxt.dao.impl;

import com.bjsxt.entity.Function;   
import com.bjsxt.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.FunctionDao;

public class FunctionDaoImpl implements FunctionDao{

	@Override
	public int insert(Function  Function) {
		
		String  sql="insert  into   afuncinfo  values(?,?)";
		
		Object [] prams={Function.getFid(),Function.getFname()};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
	
	@Override
	public List<Function> selectAll() {
		
		String  sql="select  *  from  afuncinfo";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Function>  list=new ArrayList<Function>();
		try {
			while(rs.next()){
				 
			 
			
				 
				 String Fid= rs.getString("Fid");
				 
				 String Fname=rs.getString("Fname");

				
				
				
				
				 Function function=new  Function(Fid, Fname);
			   
				 
				
				
				list.add(function);
			
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
	public int delete(String Fid) {
		
		String  sql="delete  from  afuncinfo  where  Fid=?";
		
		Object [] prams={Fid};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}

	@Override
	public Function selectOne(String Fid) {
		
		String  sql="select  *  from afuncinfo  where Fid=?";
		
		Object  [] prams={Fid};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		Function function=null;
		try {
			while(rs.next()){
				String  Fid1=rs.getString("Fid");

				String Fname=rs.getString("Fname");
			
			    function=new Function(Fid, Fname);;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return function;
	}
	@Override
	public int update(Function function) {
		
		  String  sql="update  afuncinfo set Fname=? Where Fid=?";
		  
		  Object [] prams={function.getFname(),function.getFid()};
		 
		  int  update=DBUtil.executeUpdate(sql, prams);
		
		  DBUtil.closeAll();
		   
		return  update;
	}
	@Override
	public List<Function> selectLike(String Fname) {
		
		String  sql="select  *  from  afuncinfo  where Fname=?";

		Object [] prams={Fname};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Function>  list=new  ArrayList<Function>();
		try {
			while(rs.next()){
                 String Fid=rs.getString("Fid");
 
				 String Fname1=rs.getString("Fname");
				
				Function  function=new  Function(Fid, Fname1);
			   
				list.add(function);
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
