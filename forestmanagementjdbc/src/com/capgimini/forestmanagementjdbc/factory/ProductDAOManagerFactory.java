package com.capgimini.forestmanagementjdbc.factory;

import com.capgimini.forestmanagementjdbc.dao.ProductDAO;
import com.capgimini.forestmanagementjdbc.dao.ProductDAOImpl;
import com.capgimini.forestmanagementjdbc.service.ProductService;
import com.capgimini.forestmanagementjdbc.service.ProductServiceImpl;

//create one class name ProductDAOManager
public class ProductDAOManagerFactory {
	public static ProductDAO getProductDAO() {//create one method of ProductDAO
		return new ProductDAOImpl(); 	//return ProductDAOImpl
	}

	public static ProductDAO instanceOfProductDAOImpl() {
		ProductDAO dao= new ProductDAOImpl();
		return dao;
	   }

	public static ProductService instanceOfProductServiceImpl() {
		ProductService service=new ProductServiceImpl();
		return service;
	}
}//end of class



