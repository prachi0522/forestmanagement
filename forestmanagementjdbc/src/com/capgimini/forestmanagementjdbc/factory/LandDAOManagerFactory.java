package com.capgimini.forestmanagementjdbc.factory;

import com.capgimini.forestmanagementjdbc.dao.LandDAO;
import com.capgimini.forestmanagementjdbc.dao.LandDAOImpl;
import com.capgimini.forestmanagementjdbc.service.LandService;
import com.capgimini.forestmanagementjdbc.service.LandServiceImpl;

//create one class name LandDAOManager
public class LandDAOManagerFactory {
	public static LandDAO getLandDAO() {//create one method of LandDAO
		return new LandDAOImpl(); 	//return LandDAOImpl
	}

	public static LandDAO instanceOfLandDAOImpl() {
		LandDAO dao= new LandDAOImpl();
		return dao;
	   }

	public static LandService instanceOfLandServiceImpl() {
		LandService service=new LandServiceImpl();
		return service;
	}
}//end of class



