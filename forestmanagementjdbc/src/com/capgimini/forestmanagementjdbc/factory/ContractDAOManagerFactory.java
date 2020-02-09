package com.capgimini.forestmanagementjdbc.factory;

import com.capgimini.forestmanagementjdbc.dao.ContractDAO;
import com.capgimini.forestmanagementjdbc.dao.ContractDAOImpl;
import com.capgimini.forestmanagementjdbc.service.ContractService;
import com.capgimini.forestmanagementjdbc.service.ContractServiceImpl;

//Create one class
public class ContractDAOManagerFactory {
	public static ContractDAO getContractDAO() {
		return new ContractDAOImpl(); 	//return ContractDAOImpl()
	}

	public static ContractDAO instanceOfContactDAOImpl() {
		ContractDAO dao= new ContractDAOImpl();
		return dao;
	   }

	public static ContractService instanceOfContactServiceImpl() {
		ContractService service= new ContractServiceImpl();
		return service;
	   }
	
}//end of class
