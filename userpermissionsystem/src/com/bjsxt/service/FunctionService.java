package com.bjsxt.service;
import java.util.List;  

 
import com.bjsxt.entity.Function;
public interface FunctionService {
	  public int  FunctionRegister(Function Function);
	  public List<Function>  FunctionFindAll();
	  public int FunctionRemove(String Fid);
	  public Function FunctionFindOne(String Fid);
	  public int FunctionChange(Function Function);
	  public List<Function> FunctionFindLike(String Fname);
}
