package com.capgimini.forestmanagementjdbc.factory;

import com.capgimini.forestmanagementjdbc.dao.AdminDAO;
import com.capgimini.forestmanagementjdbc.dao.AdminDAOImpl;
import com.capgimini.forestmanagementjdbc.dao.ContractDAO;
import com.capgimini.forestmanagementjdbc.dao.ContractDAOImpl;
import com.capgimini.forestmanagementjdbc.dao.CustomerDAO;
import com.capgimini.forestmanagementjdbc.dao.CustomerDAOImpl;
import com.capgimini.forestmanagementjdbc.dao.LandDAO;
import com.capgimini.forestmanagementjdbc.dao.LandDAOImpl;
import com.capgimini.forestmanagementjdbc.dao.ProductDAO;
import com.capgimini.forestmanagementjdbc.dao.ProductDAOImpl;
import com.capgimini.forestmanagementjdbc.service.AdminService;
import com.capgimini.forestmanagementjdbc.service.AdminServiceImpl;
import com.capgimini.forestmanagementjdbc.service.ContractService;
import com.capgimini.forestmanagementjdbc.service.ContractServiceImpl;
import com.capgimini.forestmanagementjdbc.service.CustomerService;
import com.capgimini.forestmanagementjdbc.service.CustomerServiceImpl;
import com.capgimini.forestmanagementjdbc.service.LandService;
import com.capgimini.forestmanagementjdbc.service.LandServiceImpl;
import com.capgimini.forestmanagementjdbc.service.ProductService;
import com.capgimini.forestmanagementjdbc.service.ProductServiceImpl;

public class FactoryDetails {
 private FactoryDetails() {
	 
 }
 
   public static AdminDAO objectAdminDAO() {
	   AdminDAO adao = new AdminDAOImpl();
	   return adao;
   }
	
   public static AdminService objectAdminServ() {
	   AdminService sDAO = new AdminServiceImpl();
	   return sDAO;
   }
	
	public static ContractDAO objectContractDAO() {
		ContractDAO daoc = new ContractDAOImpl();
		return daoc;
	}
	
	public static ContractService objectContractServices() {
		ContractService conServ = new ContractServiceImpl();
		return conServ;
	}
	
	public static CustomerDAO objectCustomerDAO() {
		CustomerDAO DAOc = new CustomerDAOImpl();
		return DAOc;
	}
	
	public static CustomerService objectCustomerServices() {
		CustomerService custServ = new CustomerServiceImpl();
		return custServ;
	}
	
 public static LandDAO objectDAOLand() {
 	LandDAO daol = new LandDAOImpl();
 	return daol;
 }
 
 public static LandService objectLandServices() {
		LandService lServ =new LandServiceImpl();
		return lServ;
	}
 
 public static ProductDAO objectProductDAO() {
 	ProductDAO daop = new ProductDAOImpl();
 	return daop;
 }
 
 public static ProductService objectProductServices() {
 	ProductService proServ = new ProductServiceImpl();
 	return proServ;
 }



}