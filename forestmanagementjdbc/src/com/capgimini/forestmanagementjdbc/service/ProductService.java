package com.capgimini.forestmanagementjdbc.service;

import java.util.List;

import com.capgimini.forestmanagementjdbc.bean.ProductBean;

public interface ProductService {
	public List<ProductBean> getAllProductss() ;
	public boolean deleteProduct(int prodid);
	public boolean addProduct(ProductBean bean);
	boolean modifyProduct(ProductBean bean);
}//end of interface
