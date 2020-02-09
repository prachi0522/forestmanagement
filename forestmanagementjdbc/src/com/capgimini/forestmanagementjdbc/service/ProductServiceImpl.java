package com.capgimini.forestmanagementjdbc.service;

import java.util.List;

import com.capgimini.forestmanagementjdbc.bean.ProductBean;
import com.capgimini.forestmanagementjdbc.dao.ProductDAO;
import com.capgimini.forestmanagementjdbc.factory.ProductDAOManagerFactory;

public class ProductServiceImpl implements ProductService{

	ProductDAO dao= ProductDAOManagerFactory.instanceOfProductDAOImpl();
	@Override
	public List<ProductBean> getAllProductss() {
		return dao.getAllProductss();
	}

	@Override
	public boolean deleteProduct(int prodid) {
		return dao.deleteProduct(prodid);
	}

	@Override
	public boolean addProduct(ProductBean bean) {
		return dao.addProduct(bean);
	}

	@Override
	public boolean modifyProduct(ProductBean bean) {
		return dao.modifyProduct(bean);
	}
}
