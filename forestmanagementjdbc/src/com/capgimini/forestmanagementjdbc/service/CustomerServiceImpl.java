package com.capgimini.forestmanagementjdbc.service;

import java.util.List;

import com.capgimini.forestmanagementjdbc.bean.CustomerBean;
import com.capgimini.forestmanagementjdbc.dao.CustomerDAO;
import com.capgimini.forestmanagementjdbc.factory.CustomerDAOManagerFactory;

public class CustomerServiceImpl implements CustomerService{
	CustomerDAO dao=CustomerDAOManagerFactory.instanceOfCustomerDAOImpl();

	@Override
	public List<CustomerBean> getAllCustomers() {
		return dao.getAllCustomers();
	}

	@Override
	public boolean deleteCustomer(int customerid3) {
		return dao.deleteCustomer(customerid3);
	}

	@Override
	public boolean addCustomer(CustomerBean bean) {
		return dao.addCustomer(bean);
	}

	@Override
	public boolean modifyCustomer(CustomerBean bean) {
		return dao.modifyCustomer(bean);
	}

}
