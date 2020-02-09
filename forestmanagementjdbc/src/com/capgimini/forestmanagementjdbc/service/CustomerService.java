package com.capgimini.forestmanagementjdbc.service;
import java.util.List;

import com.capgimini.forestmanagementjdbc.bean.CustomerBean;

//create one interface CustomerDAO
public interface CustomerService {
	//declare some methods 
	public List<CustomerBean> getAllCustomers() ;
	public boolean deleteCustomer(int customerid3);
	public boolean addCustomer(CustomerBean bean);
	boolean modifyCustomer(CustomerBean bean);


}//end one interface
