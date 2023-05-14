package com.bjsxt.service;
import java.util.List; 

import com.bjsxt.entity.UserRole;
public interface UserRoleService {
	  public int  UserRoleRegister(UserRole UserRole);
	  public List<UserRole>  UserRoleFindAll();
	  public int UserRoleRemove(String URid);
	  public UserRole UserRoleFindOne(String URid);
	  public int UserRoleChange(UserRole UserRole);
	  public List<UserRole> UserRoleFindLike(String URid);
}
