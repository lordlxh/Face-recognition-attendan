package com.bjsxt.service;
import java.util.List; 

 
import com.bjsxt.entity.Role;
public interface RoleService {
	  public int  RoleRegister(Role Role);
	  public List<Role>  RoleFindAll();
	  public int RoleRemove(String Rid);
	  public Role RoleFindOne(String Rid);
	  public int RoleChange(Role Role);
	  public List<Role> RoleFindLike(String Rname);
}
