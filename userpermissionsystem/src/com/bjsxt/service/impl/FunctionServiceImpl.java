package com.bjsxt.service.impl;

import java.util.List; 

import com.bjsxt.entity.Function;
 
import com.bjsxt.dao.FunctionDao;
import com.bjsxt.dao.impl.FunctionDaoImpl;

import com.bjsxt.service.FunctionService;

public class FunctionServiceImpl implements FunctionService{
	FunctionDao roledao=new FunctionDaoImpl();
@Override
		  public int  FunctionRegister(Function Role) {return roledao.insert(Role);}
@Override
		  public List<Function>  FunctionFindAll(){return roledao.selectAll();}
@Override
		  public int FunctionRemove(String Rid){return roledao.delete(Rid);}
@Override
		  public Function FunctionFindOne(String Rid){return roledao.selectOne(Rid);}
@Override
		  public int FunctionChange(Function Role){return roledao.update(Role);}
@Override
		  public List<Function> FunctionFindLike(String Rname){return roledao.selectLike(Rname);}
		
}
