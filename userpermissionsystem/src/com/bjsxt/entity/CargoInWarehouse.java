package com.bjsxt.entity;
 
import java.io.Serializable;

import java.util.Date; 



public class CargoInWarehouse implements Serializable{
    private String cargoNo;
    
    private float cargoweight;
    
    private String cargovariety;
    
    private String WNo;
    
    private String ONo;
    
    private String CRNo;
    
	public CargoInWarehouse() {
		super();
	}
	
    
	public CargoInWarehouse(String cargoNo, float cargoweight,String cargovariety,String WNo,String ONo,String CRNo) {
		super();
		this.cargoNo = cargoNo;
		this.cargoweight = cargoweight;
		this.cargovariety = cargovariety;
		this.WNo = WNo;
		this.ONo = ONo;
	    this.CRNo= CRNo;
	}
	

	
	public String getcargoNo() {
		return cargoNo;
	}

	public void setcargoNo(String cargoNo) {
		this.cargoNo = cargoNo;
	}

	public float getcargoweight() {
		return cargoweight;
	}

	public void setcargoweight(float cargoweight) {
		this.cargoweight = cargoweight;
	}
	public String getcargovariety() {
		return cargovariety;
	}

	public void setcargovariety(String cargovariety) {
		this.cargovariety = cargovariety;
	}


	public String getWNo() {
		return WNo;
	}

	public void setWNo(String WNo) {
		this.WNo = WNo;
	}

	public String getONo() {
		return ONo;
	}

	public void setONo(String ONo) {
		this.ONo = ONo;
	}
    
	public String getCRNo() {
		return CRNo;
	}

	public void setCRNo(String CRNo) {
		this.CRNo = CRNo;
	}


	@Override
	public String toString() {
		return "CargoInWarehouse [cargoNo=" + cargoNo + ",  cargoweight=" + cargoweight + "]";
	}

    
}
