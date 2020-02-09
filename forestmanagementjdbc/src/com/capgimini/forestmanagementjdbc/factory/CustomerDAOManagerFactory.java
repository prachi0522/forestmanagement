package com.capgimini.forestmanagementjdbc.factory;

import com.capgimini.forestmanagementjdbc.dao.CustomerDAO;
import com.capgimini.forestmanagementjdbc.dao.CustomerDAOImpl;
import com.capgimini.forestmanagementjdbc.service.CustomerService;
import com.capgimini.forestmanagementjdbc.service.CustomerServiceImpl;

//create one class
public class CustomerDAOManagerFactory {
	public static CustomerDAO getCustomerDAO() {
		return new CustomerDAOImpl(); 	
	}

	public static CustomerDAO instanceOfCustomerDAOImpl() {
		CustomerDAO dao= new CustomerDAOImpl();
		return dao;
	   }

	public static CustomerService instanceOfCustomerServiceImpl() {
		CustomerService service= new CustomerServiceImpl();
		return service;
	}

	
}//end of class
