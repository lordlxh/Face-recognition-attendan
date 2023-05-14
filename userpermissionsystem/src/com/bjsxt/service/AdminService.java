package com.bjsxt.service;

import java.util.List;     

import com.bjsxt.entity.Admin;
import com.bjsxt.entity.Student;
 
import com.bjsxt.entity.CargoRecorder;
import com.bjsxt.entity.CargoInWarehouse;;

public interface AdminService {
	
	//货物记录员系列
	  public int  CargoRecorderRegister(CargoRecorder CargoRecorder);
	  public List<CargoRecorder>  cargorecorderFindAll();
	  public int CargoRecorderRemove(int CRNo);
	  public CargoRecorder CargoRecorderFindOne(int CRNo);
	  public int CargoRecorderChange(CargoRecorder CargoRecorder) ;
	  public List<CargoRecorder> CargoRecorderFindLike(String CRname);
	//入库货物系列
	  public int  CargoInWarehouseRegister(CargoInWarehouse CargoInWarehouse);
	  public List<CargoInWarehouse>  CargoInWarehouseFindAll();
	  public int CargoInWarehouseRemove(int cargoNo);
	  public CargoInWarehouse CargoInWarehouseFindOne(int cargoNo);
	  public int CargoInWarehouseChange(CargoInWarehouse CargoInWarehouse) ;
	  public List<CargoInWarehouse> CargoInWarehouseFindLike(String cargovariety);
	
	
	
	
	//管理员登陆操作
		public   Admin  adminLogin(String uid,String pwd);
		
		public	int adminRegister(Admin admin);
		
		//管理员添加学生的操作
		public  int   stuRegister(Student stu);
		
		//查询所有的操作
	public   List<Student> stuFindAll();
	
	public  int   stuRemove(int  clazzno); 
}
