package com.bjsxt.service;
import java.util.List;  

import com.bjsxt.entity.RoleFunc;
public interface RoleFuncService {
	  public int  RoleFuncRegister(RoleFunc RoleFunc);
	  public List<RoleFunc>  RoleFuncFindAll();
	  public int RoleFuncRemove(String RFid);
	  public RoleFunc RoleFuncFindOne(String RFid);
	  public int RoleFuncChange(RoleFunc RoleFunc);
	  public List<RoleFunc> RoleFuncFindLike(String RFid);
}
