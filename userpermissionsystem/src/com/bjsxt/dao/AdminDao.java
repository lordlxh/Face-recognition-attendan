package com.bjsxt.dao;

import com.bjsxt.entity.Admin;

public interface AdminDao {
	
	//管理员查询单个操作
	public    Admin   selectOne(String uid,String pwd);
	
	//添加的操作
	public  int   insert(Admin   admin);

}
