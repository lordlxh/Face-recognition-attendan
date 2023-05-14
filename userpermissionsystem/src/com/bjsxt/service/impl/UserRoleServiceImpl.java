package com.bjsxt.service.impl;

import java.util.List; 

import com.bjsxt.entity.UserRole;
 
import com.bjsxt.dao.UserRoleDao;
import com.bjsxt.dao.impl.UserRoleDaoImpl;

import com.bjsxt.service.UserRoleService;

public class UserRoleServiceImpl implements UserRoleService{
	UserRoleDao userroledao=new UserRoleDaoImpl();
@Override
		  public int  UserRoleRegister(UserRole UserRole) {return userroledao.insert(UserRole);}
@Override
		  public List<UserRole>  UserRoleFindAll(){return userroledao.selectAll();}
@Override
		  public int UserRoleRemove(String URid){return userroledao.delete(URid);}
@Override
		  public UserRole UserRoleFindOne(String URid){return userroledao.selectOne(URid);}
@Override
		  public int UserRoleChange(UserRole UserRole){return userroledao.update(UserRole);}
@Override
		  public List<UserRole> UserRoleFindLike(String URid){return userroledao.selectLike(URid);}
		
}
