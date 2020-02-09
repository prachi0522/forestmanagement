package com.capgimini.forestmanagementjdbc.dao;

import java.util.List;

import com.capgimini.forestmanagementjdbc.bean.ProductBean;

//create one interface
public interface ProductDAO {
	public List<ProductBean> getAllProductss() ;
	public boolean deleteProduct(int prodid);
	public boolean addProduct(ProductBean bean);
	boolean modifyProduct(ProductBean bean);
}//end of interface

