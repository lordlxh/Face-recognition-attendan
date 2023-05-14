package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.entity.User;
import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;

import com.bjsxt.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userdao=new UserDaoImpl();
	@Override
	public User UserLogin(String Uid,String pwd) {return userdao.querylogin(Uid, pwd);}
	@Override
	public String Permissioncheck(String Uid) {return userdao.permissionconfirm(Uid);}
	@Override
	public int  StudentRegister(User User){return userdao.StuRegister(User);}
	@Override
	public int  UserRegister(User User) {return userdao.insert(User);}
	@Override
	public List<User>  UserFindAll(){return userdao.selectAll();}
	@Override
	public List<User>  StudentFindAll(){return userdao.selectStudent();}
	@Override
	public List<User>  TeacherFindAll(){return userdao.selectTeacher();}
	@Override
	 public int UserRemove(String Uid) {return userdao.delete(Uid);}
	@Override
	 public User UserFindOne(String Uid) {return userdao.selectOne(Uid);}
	@Override  
	public int UserChange(User User) {return userdao.update(User);}
	@Override
	 public List<User> UserFindLike(String Uname){return userdao.selectLike(Uname);}
}
