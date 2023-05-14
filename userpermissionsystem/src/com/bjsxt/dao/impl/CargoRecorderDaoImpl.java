package com.bjsxt.dao.impl;

import com.bjsxt.entity.CargoRecorder; 
import com.bjsxt.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.CargoRecorderDao;

public class CargoRecorderDaoImpl implements CargoRecorderDao{

	@Override
	public int insert(CargoRecorder  CargoRecorder) {
		
		String  sql="insert  into   cargorecorders  values(?,?)";
		
		Object [] prams={CargoRecorder.getCRname(),CargoRecorder.getCRNo()};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
	
	@Override
	public List<CargoRecorder> selectAll() {
		
		String  sql="select  *  from  cargorecorders";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<CargoRecorder>  list=new ArrayList<CargoRecorder>();
		try {
			while(rs.next()){
				 
				//学生的信息
			
				 
				 String CRname=rs.getString("CRname");
				 
				 String CRNo=rs.getString("CRNo");

				
				
				
				
				CargoRecorder  cargorecorder=new  CargoRecorder(CRname, CRNo);
			   
				 
				
				
				list.add(cargorecorder);
			
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
	public int delete(int CRNo) {
		
		String  sql="delete  from  cargorecorders  where  CRNo=?";
		
		Object [] prams={CRNo};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}

	@Override
	public CargoRecorder selectOne(int CRNo) {
		
		String  sql="select  *  from cargorecorders  where CRNo=?";
		
		Object  [] prams={CRNo};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		CargoRecorder  cargorecorder=null;
		try {
			while(rs.next()){
				String  CRNo1=rs.getString("CRNo");

				String CRname=rs.getString("CRname");
			
			    cargorecorder=new  CargoRecorder(CRname, CRNo1);;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return cargorecorder;
	}
	@Override
	public int update(CargoRecorder cargorecorder) {
		
		  String  sql="update  cargorecorders set CRname=? Where CRNo=?";
		  
		  Object [] prams={cargorecorder.getCRname(),cargorecorder.getCRNo()};
		 
		  int  update=DBUtil.executeUpdate(sql, prams);
		
		  DBUtil.closeAll();
		   
		return  update;
	}
	@Override
	public List<CargoRecorder> selectLike(String CRname) {
		
		String  sql="select  *  from  cargorecorders  where CRname=?";

		Object [] prams={CRname};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<CargoRecorder>  list=new  ArrayList<CargoRecorder>();
		try {
			while(rs.next()){
                 String CRname1=rs.getString("CRname");
 
				 String CRNo=rs.getString("CRNo");
				
				CargoRecorder  cargorecorder=new  CargoRecorder(CRname1, CRNo);
			   
				list.add(cargorecorder);
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
