package com.bjsxt.dao.impl;

import com.bjsxt.entity.User;
import com.bjsxt.entity.UserRole;
import com.bjsxt.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.UserDao; 

public class UserDaoImpl implements UserDao{

	//registerstu
	@Override
	public   int   StuRegister(User User) {
        String  sql="select  *  from  auserroleinfo";
		
		Object [] prams={};
		
		
		int a=0;
		int i;
		for (i=1;i<10000;i++) {a=0;
		try {
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		while(rs.next()){
            String URid=rs.getString("URid");
            System.out.print(i);
            System.out.print(Integer.parseInt(URid));
            if (Integer.parseInt(URid)==i) {
            	System.out.print(i);
                System.out.print(Integer.parseInt(URid));
            	a=1;
            	}
            	
            }
	}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		if (a==0)break; }
		//插入user表
        String  sql1="insert  into   auserinfo  values(?,?,?,?,?,?)";
		
		Object [] prams1={User.getUid(),User.getUname(),User.getpwd(),User.getsfz(),User.getphone(),User.getphotoname()};
		
		int  update1= DBUtil.executeUpdate(sql1, prams1);
		
		//插入userrole
		
        String  sql2="insert  into   auserroleinfo  values(?,?,3)";
		String ii=Integer.toString(i);
		Object [] prams2={ii,User.getUid()};
		
		int  update2= DBUtil.executeUpdate(sql2, prams2);
		
		DBUtil.closeAll();
		
	
		return update2;
		
	}
		
//login
	@Override
	public User querylogin(String Uid, String pwd) {
		String  sql="select *  from  auserinfo   where  Uid=?  and  pwd=?";
		
		Object [] prams={Uid,pwd};
		
ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		User user=null;
		try {
			while(rs.next()){

				 String Uname=rs.getString("Uname");				 
				 String sfz=rs.getString("sfz");
				 String phone=rs.getString("phone");
				 String photoname=rs.getString("photoname");
				 user=new  User(Uid,Uname,pwd,sfz,phone,photoname);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return user;
		
		
	}
//permission confirm
	@Override
	public String permissionconfirm(String Uid) {
		String sql="SELECT afuncinfo.Fid FROM afuncinfo,aroleinfo,auserinfo,auserroleinfo,arolefuncinfo WHERE afuncinfo.Fid=arolefuncinfo.Fid AND arolefuncinfo.Rid=aroleinfo.Rid AND aroleinfo.Rid=auserroleinfo.Rid AND auserroleinfo.Uid=auserinfo.Uid AND auserinfo.Uid=?";
		Object [] prams={Uid};
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		String percode0="000000";
		int Fid0=0;
		StringBuilder sb = new StringBuilder(percode0);
		try {
			while(rs.next()) {
				Fid0=Integer.parseInt(rs.getString("Fid"));
			    sb.replace(Fid0-1,Fid0, String.valueOf('1'));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
	    String percode1=sb.toString();
		return percode1;
	}
	
	
	
	
	
	//插入数据
	@Override
	public int insert(User  User) {
		
		String  sql="insert  into   auserinfo  values(?,?,?,?,?,?)";
		
		Object [] prams={User.getUid(),User.getUname(),User.getpwd(),User.getsfz(),User.getphone(),User.getphotoname()};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
//查询所有元组	
	@Override
	public List<User> selectAll() {
		
		String  sql="select  *  from  auserinfo";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<User>  list=new ArrayList<User>();
		try {
			while(rs.next()){
				 
				//用户的信息
				String Uid=rs.getString("Uid");
				 String Uname=rs.getString("Uname");
				 String pwd=rs.getString("pwd");				 
				 String sfz=rs.getString("sfz");
				 String phone=rs.getString("phone");
                 String photoname=rs.getString("photoname");
				 User  user=new  User(Uid,Uname,pwd,sfz,phone,photoname);
				list.add(user);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return list;
	}
//查学生	
	@Override
	public List<User> selectStudent() {
		
		String  sql="select  *  from  auserinfo,auserroleinfo,aroleinfo where auserinfo.Uid=auserroleinfo.Uid and auserroleinfo.Rid=aroleinfo.Rid and aroleinfo.Rname=\"学生\"";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<User>  list=new ArrayList<User>();
		try {
			while(rs.next()){
				 
				//用户的信息
				String Uid=rs.getString("Uid");
				 String Uname=rs.getString("Uname");
				 String pwd=rs.getString("pwd");				 
				 String sfz=rs.getString("sfz");
				 String phone=rs.getString("phone");
				 String photoname=rs.getString("photoname");
				 User  user=new  User(Uid,Uname,pwd,sfz,phone,photoname);
				list.add(user);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return list;
	}
	
	@Override
	public List<User> selectTeacher() {
		
		String  sql="select  *  from  auserinfo,auserroleinfo,aroleinfo where auserinfo.Uid=auserroleinfo.Uid and auserroleinfo.Rid=aroleinfo.Rid and aroleinfo.Rname=\"教师\"";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<User>  list=new ArrayList<User>();
		try {
			while(rs.next()){
				 
				//用户的信息
				String Uid=rs.getString("Uid");
				 String Uname=rs.getString("Uname");
				 String pwd=rs.getString("pwd");				 
				 String sfz=rs.getString("sfz");
				 String phone=rs.getString("phone");
				 String photoname=rs.getString("photoname");
				 User  user=new  User(Uid,Uname,pwd,sfz,phone,photoname);
				list.add(user);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return list;
	}
	
//删除
	@Override
	public int delete(String Uid) {
		
		String  sql="delete  from  auserinfo  where  Uid=?";
		
		Object [] prams={Uid};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}
//按Uid选择，为更新做铺垫
	@Override
	public User selectOne(String Uid) {
		
		String  sql="select  *  from auserinfo  where Uid=?";
		
		Object  [] prams={Uid};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		User user=null;
		try {
			while(rs.next()){
				String Uid1=rs.getString("Uid");
				 String Uname=rs.getString("Uname");
				 String pwd=rs.getString("pwd");				 
				 String sfz=rs.getString("sfz");
				 String phone=rs.getString("phone");
				 String photoname=rs.getString("photoname");
				 user=new  User(Uid,Uname,pwd,sfz,phone,photoname);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return user;
	}
//更新
	@Override
	public int update(User User) {
		
		  String  sql="update  auserinfo set Uname=?,pwd=?,sfz=?,phone=?,photoname=? Where Uid=?";
		  
		  Object [] prams={User.getUname(),User.getpwd(),User.getsfz(),User.getphone(),User.getphotoname(),User.getUid()};
		 
		  int  update=DBUtil.executeUpdate(sql, prams);
		
		  DBUtil.closeAll();
		   
		return  update;
	}
//按用户名查询
	@Override
	public List<User> selectLike(String Uname) {
		
		String  sql="select  *  from  auserinfo  where Uname like ?";

		Object [] prams={"%"+Uname+"%"};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<User>  list=new  ArrayList<User>();
		try {
			while(rs.next()){
				Uname=rs.getString("Uname");
				String Uid=rs.getString("Uid");
				 String pwd=rs.getString("pwd");				 
				 String sfz=rs.getString("sfz");
				 String phone=rs.getString("phone");
				 String photoname=rs.getString("photoname");
				 User user=new  User(Uid,Uname,pwd,sfz,phone,photoname);
			   
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return list;
	}

}
