package com.capgimini.forestmanagementjdbc.dao;

import java.util.List;

import com.capgimini.forestmanagementjdbc.bean.CustomerBean;
import com.capgimini.forestmanagementjdbc.bean.LandBean;

//create one interface CustomerDAO
public interface LandDAO {
	//declare some methods 
	public List<LandBean> getAllLands() ;
	public boolean deleteLand(int id);
	public boolean addLand(LandBean bean);
	boolean modifyLand(LandBean bean);

}//end one interface
