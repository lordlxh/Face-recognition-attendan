package com.bjsxt.dao;

import java.util.List;

 
import com.bjsxt.entity.User;
 

public interface UserDao {
	public User querylogin(String Uid, String pwd);
    public String permissionconfirm(String Uid);
	public   int   insert(User  User);
	public   int   StuRegister(User User);
	public   List<User> selectAll();
	public   List<User> selectStudent();
	public   List<User> selectTeacher();
	public int delete(String Uid);
	public User selectOne(String Uid);
	public int update(User user);
	public List<User> selectLike(String Uname);
}
