package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.entity.Role;
 
import com.bjsxt.dao.RoleDao;
import com.bjsxt.dao.impl.RoleDaoImpl;

import com.bjsxt.service.RoleService;

public class RoleServiceImpl implements RoleService{
	RoleDao roledao=new RoleDaoImpl();
@Override
		  public int  RoleRegister(Role Role) {return roledao.insert(Role);}
@Override
		  public List<Role>  RoleFindAll(){return roledao.selectAll();}
@Override
		  public int RoleRemove(String Rid){return roledao.delete(Rid);}
@Override
		  public Role RoleFindOne(String Rid){return roledao.selectOne(Rid);}
@Override
		  public int RoleChange(Role Role){return roledao.update(Role);}
@Override
		  public List<Role> RoleFindLike(String Rname){return roledao.selectLike(Rname);}
		
}
