package com.bjsxt.dao;

import java.util.List; 


import com.bjsxt.entity.UserRole;

public interface UserRoleDao {
	public   int   insert(UserRole  UserRole);
	public   List<UserRole> selectAll();
	public int delete(String URid);
	public UserRole selectOne(String URid);
	public int update(UserRole userrole);
	public List<UserRole> selectLike(String URid);
}
