package com.bjsxt.dao;

import java.util.List;


import com.bjsxt.entity.Role;

public interface RoleDao {
	
	public   int   insert(Role  Role);
	public   List<Role> selectAll();
	public int delete(String Rid);
	public Role selectOne(String Rid);
	public int update(Role role);
	public List<Role> selectLike(String Rname);
}
