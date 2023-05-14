package com.bjsxt.service.impl;

import java.util.List;   


import com.bjsxt.dao.AdminDao;
import com.bjsxt.dao.StudentDao;
import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.RoleDao;
import com.bjsxt.dao.CargoRecorderDao;
import com.bjsxt.dao.CargoInWarehouseDao;
import com.bjsxt.dao.impl.AdminDaoImpl;
import com.bjsxt.dao.impl.StudentDaoImpl;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.dao.impl.RoleDaoImpl;
import com.bjsxt.dao.impl.CargoRecorderDaoImpl;
import com.bjsxt.dao.impl.CargoInWarehouseDaoImpl;
import com.bjsxt.entity.Admin;
import com.bjsxt.entity.CargoInWarehouse;
import com.bjsxt.entity.Student;
import com.bjsxt.entity.User;
import com.bjsxt.entity.Role;
import com.bjsxt.entity.CargoRecorder;

import com.bjsxt.service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	AdminDao  admindao=new  AdminDaoImpl();
	StudentDao   studao=new  StudentDaoImpl();
	CargoRecorderDao cargorecorderdao=new CargoRecorderDaoImpl();
	CargoInWarehouseDao cargoinwarehousedao=new CargoInWarehouseDaoImpl();

			
	//货物记录员
	@Override
	public int CargoRecorderRegister(CargoRecorder CargoRecorder) {
		// TODO Auto-generated method stub
		return cargorecorderdao.insert(CargoRecorder);
	}
	@Override
	public List<CargoRecorder>  cargorecorderFindAll(){
		return cargorecorderdao.selectAll();
	}
	@Override
	public int CargoRecorderRemove(int CRNo) {
		return cargorecorderdao.delete(CRNo);
	}
	@Override
	public CargoRecorder CargoRecorderFindOne(int CRNo) {
		// TODO Auto-generated method stub
		return cargorecorderdao.selectOne(CRNo);
	}
	@Override
	public int CargoRecorderChange(CargoRecorder CargoRecorder) {
		// TODO Auto-generated method stub
		return cargorecorderdao.update(CargoRecorder);
	}
	@Override
	public List<CargoRecorder> CargoRecorderFindLike(String CRname) {
		// TODO Auto-generated method stub
		return cargorecorderdao.selectLike(CRname);
	}
    
	
	//入库货物
	
	
	@Override
	public int CargoInWarehouseRegister(CargoInWarehouse CargoInWarehouse) {
		// TODO Auto-generated method stub
		return cargoinwarehousedao.insert(CargoInWarehouse);
	}
	@Override
	public List<CargoInWarehouse>  CargoInWarehouseFindAll(){
		return cargoinwarehousedao.selectAll();
	}
	@Override
	public int CargoInWarehouseRemove(int cargoNo) {
		return cargoinwarehousedao.delete(cargoNo);
	}
	@Override
	public CargoInWarehouse CargoInWarehouseFindOne(int cargoNo) {
		// TODO Auto-generated method stub
		return cargoinwarehousedao.selectOne(cargoNo);
	}
	@Override
	public int CargoInWarehouseChange(CargoInWarehouse CargoInWarehouse) {
		// TODO Auto-generated method stub
		return cargoinwarehousedao.update(CargoInWarehouse);
	}
	@Override
	public List<CargoInWarehouse> CargoInWarehouseFindLike(String cargovariety) {
		// TODO Auto-generated method stub
		return cargoinwarehousedao.selectLike(cargovariety);
	}
	
    	
	
	
	
	
	
	
	@Override
	public Admin adminLogin(String uid,String pwd) {
		// TODO Auto-generated method stub
		return admindao.selectOne(uid, pwd);
	}

	@Override
	public int adminRegister(Admin admin) {
		// TODO Auto-generated method stub
		return admindao.insert(admin);
	}
	

	@Override
	public  int   stuRegister(Student stu){
		// TODO Auto-generated method stub
		return studao.insert(stu);
	}
	

	@Override
	public  List<Student>  stuFindAll(){
		// TODO Auto-generated method stub
		return studao.selectAll();
	}
	@Override
	public  int   stuRemove(int  clazzno) {
		return  studao.delete(clazzno);
	}
	}

