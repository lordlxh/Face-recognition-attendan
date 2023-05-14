package com.bjsxt.dao.impl;

import com.bjsxt.entity.CargoInWarehouse;
 
import com.bjsxt.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.CargoInWarehouseDao;

public class CargoInWarehouseDaoImpl implements CargoInWarehouseDao{
//插入数据
	@Override
	public int insert(CargoInWarehouse  CargoInWarehouse) {
		
		String  sql="insert  into   cargoinwarehouse  values(?,?,?,?,?,?)";
		
		Object [] prams={CargoInWarehouse.getcargoNo(),CargoInWarehouse.getcargoweight(),CargoInWarehouse.getcargovariety(),CargoInWarehouse.getWNo(),CargoInWarehouse.getONo(),CargoInWarehouse.getCRNo()};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
//查询所有元组	
	@Override
	public List<CargoInWarehouse> selectAll() {
		
		String  sql="select  *  from  cargoinwarehouse";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<CargoInWarehouse>  list=new ArrayList<CargoInWarehouse>();
		try {
			while(rs.next()){
				 
				//学生的信息
			
				 
				 String cargoNo=rs.getString("cargoNo");
				 
				 float cargoweight=rs.getFloat("cargoweight");
				 
				 String cargovariety=rs.getString("cargovariety");
				 
				 String WNo=rs.getString("WNo");
                 
				 String ONo=rs.getString("ONo");
				
				 String CRNo=rs.getString("CRNo");
				
				
				 CargoInWarehouse  cargoinwarehouse=new  CargoInWarehouse(cargoNo,cargoweight,cargovariety,WNo,ONo,CRNo);
			   
				 
				
				
				list.add(cargoinwarehouse);
			
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
	public int delete(int cargoNo) {
		
		String  sql="delete  from  cargoinwarehouse  where  cargoNo=?";
		
		Object [] prams={cargoNo};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
//按货物号选择，为更新做铺垫
	@Override
	public CargoInWarehouse selectOne(int cargoNo) {
		
		String  sql="select  *  from cargoinwarehouse  where cargoNo=?";
		
		Object  [] prams={cargoNo};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		CargoInWarehouse  cargoinwarehouse=null;
		try {
			while(rs.next()){
				String cargoNo1=rs.getString("cargoNo");
				 
				 float cargoweight=rs.getFloat("cargoweight");
				 
				 String cargovariety=rs.getString("cargovariety");
				 
				 String WNo=rs.getString("WNo");
                
				 String ONo=rs.getString("ONo");
				 
				 String CRNo=rs.getString("CRNo");
			
				cargoinwarehouse=new  CargoInWarehouse(cargoNo1,cargoweight,cargovariety,WNo,ONo,CRNo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return cargoinwarehouse;
	}
//更新
	@Override
	public int update(CargoInWarehouse CargoInWarehouse) {
		
		  String  sql="update  cargoinwarehouse set cargoweight=?,cargovariety=?,WNo=?,ONo=?,CRNo=? Where cargoNo=?";
		  
		  Object [] prams={CargoInWarehouse.getcargoweight(),CargoInWarehouse.getcargovariety(),CargoInWarehouse.getWNo(),CargoInWarehouse.getONo(),CargoInWarehouse.getCRNo(),CargoInWarehouse.getcargoNo()};
		 
		  int  update=DBUtil.executeUpdate(sql, prams);
		
		  DBUtil.closeAll();
		   
		return  update;
	}
//按货物类型查询
	@Override
	public List<CargoInWarehouse> selectLike(String cargovariety) {
		
		String  sql="select  *  from  cargoinwarehouse  where cargovariety=?";

		Object [] prams={cargovariety};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<CargoInWarehouse>  list=new  ArrayList<CargoInWarehouse>();
		try {
			while(rs.next()){
				String cargoNo=rs.getString("cargoNo");
				 
				 float cargoweight=rs.getFloat("cargoweight");
				 
				 String cargovariety1=rs.getString("cargovariety");
				 
				 String WNo=rs.getString("WNo");
               
				 String ONo=rs.getString("ONo");
				 
				 String CRNo=rs.getString("CRNo");
				
				 CargoInWarehouse cargoinwarehouse=new  CargoInWarehouse(cargoNo,cargoweight,cargovariety,WNo,ONo,CRNo);
			   
				list.add(cargoinwarehouse);
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
