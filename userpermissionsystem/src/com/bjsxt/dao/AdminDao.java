package com.bjsxt.dao;

import com.bjsxt.entity.Admin;

public interface AdminDao {
	
	//����Ա��ѯ��������
	public    Admin   selectOne(String uid,String pwd);
	
	//��ӵĲ���
	public  int   insert(Admin   admin);

}
