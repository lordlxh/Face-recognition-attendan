package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.CargoRecorder;
import com.bjsxt.entity.Student;

public interface CargoRecorderDao {
	
	public   int   insert(CargoRecorder  CargoRecorder);
	public   List<CargoRecorder> selectAll();
	public int delete(int CRNo);
	public CargoRecorder selectOne(int CRNo);
	public int update(CargoRecorder cargorecorder);
	public List<CargoRecorder> selectLike(String CRname);
}
