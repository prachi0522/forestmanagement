package com.capgimini.forestmanagementjdbc.service;

import java.util.List;

import com.capgimini.forestmanagementjdbc.bean.ContractBean;

public interface ContractService {

	//define methods which we want to implement
	public List<ContractBean> getAllContracts() ;
	
	public boolean addContract(ContractBean bean1);
	public boolean deleteContract(long contractno3);
}//end of interface


