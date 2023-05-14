package com.bjsxt.service;
import java.util.List; 

 
import com.bjsxt.entity.User;
public interface UserService {
	  public User UserLogin(String Uid,String pwd);
	  public String Permissioncheck(String Uid);
	  public int  StudentRegister(User User);
	  public int  UserRegister(User User);
	  public List<User>  UserFindAll();
	  public List<User>  StudentFindAll();
	  public List<User>  TeacherFindAll();
	  public int UserRemove(String Uid);
	  public User UserFindOne(String Uid);
	  public int UserChange(User User) ;
	  public List<User> UserFindLike(String Uname);
}
