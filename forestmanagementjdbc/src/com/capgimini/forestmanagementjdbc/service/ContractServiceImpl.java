package com.capgimini.forestmanagementjdbc.service;

import java.util.List;

import com.capgimini.forestmanagementjdbc.bean.ContractBean;
import com.capgimini.forestmanagementjdbc.dao.ContractDAO;
import com.capgimini.forestmanagementjdbc.factory.ContractDAOManagerFactory;


public class ContractServiceImpl implements ContractService{
	ContractDAO dao=ContractDAOManagerFactory.instanceOfContactDAOImpl();

	@Override
	public List<ContractBean> getAllContracts() {
		return dao.getAllContracts();

	}


	@Override
	public boolean addContract(ContractBean bean1) {
		return dao.addContract(bean1);
	}


	@Override
	public boolean deleteContract(long contractno3) {
		return dao.deleteContract(contractno3);
	}

}
