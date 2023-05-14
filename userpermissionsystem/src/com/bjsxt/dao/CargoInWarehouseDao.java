package com.bjsxt.dao;

import java.util.List; 

import com.bjsxt.entity.CargoInWarehouse;
 

public interface CargoInWarehouseDao {
	
	public   int   insert(CargoInWarehouse  CargoInWarehouse);
	public   List<CargoInWarehouse> selectAll();
	public int delete(int cargoNo);
	public CargoInWarehouse selectOne(int cargoNo);
	public int update(CargoInWarehouse CargoInWarehouse);
	public List<CargoInWarehouse> selectLike(String cargovariety);
}
