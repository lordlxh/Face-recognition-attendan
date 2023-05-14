package com.bjsxt.service.impl;

import java.util.List;  

import com.bjsxt.entity.RoleFunc;
 
import com.bjsxt.dao.RoleFuncDao;
import com.bjsxt.dao.impl.RoleFuncDaoImpl;

import com.bjsxt.service.RoleFuncService;

public class RoleFuncServiceImpl implements RoleFuncService{
	RoleFuncDao userroledao=new RoleFuncDaoImpl();
@Override
public int  RoleFuncRegister(RoleFunc RoleFunc) {return userroledao.insert(RoleFunc);}
@Override
public List<RoleFunc>  RoleFuncFindAll(){return userroledao.selectAll();}
@Override
public int RoleFuncRemove(String RFid){return userroledao.delete(RFid);}
@Override
public RoleFunc RoleFuncFindOne(String RFid){return userroledao.selectOne(RFid);}
@Override
public int RoleFuncChange(RoleFunc RoleFunc){return userroledao.update(RoleFunc);}
@Override
public List<RoleFunc> RoleFuncFindLike(String RFid){return userroledao.selectLike(RFid);}
		
}
