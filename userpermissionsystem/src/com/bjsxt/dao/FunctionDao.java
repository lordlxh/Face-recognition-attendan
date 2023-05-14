package com.bjsxt.dao;
 
import java.util.List;  


import com.bjsxt.entity.Function;

public interface FunctionDao {
	
	public   int   insert(Function  Function);
	public   List<Function> selectAll();
	public int delete(String Fid);
	public Function selectOne(String Fid);
	public int update(Function function);
	public List<Function> selectLike(String Fname);
}
