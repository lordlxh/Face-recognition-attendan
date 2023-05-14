package com.bjsxt.dao;

import java.util.List;  


import com.bjsxt.entity.RoleFunc;

public interface RoleFuncDao {
	public   int   insert(RoleFunc  RoleFunc);
	public   List<RoleFunc> selectAll();
	public int delete(String RFid);
	public RoleFunc selectOne(String RFid);
	public int update(RoleFunc rolefunc);
	public List<RoleFunc> selectLike(String RFid);
}
