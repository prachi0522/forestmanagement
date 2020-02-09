package com.capgimini.forestmanagementjdbc.service;

import com.capgimini.forestmanagementjdbc.dao.AdminDAO;
import com.capgimini.forestmanagementjdbc.factory.FactoryDetails;

public class AdminServiceImpl implements AdminService{

	AdminDAO adao = FactoryDetails.objectAdminDAO();
	@Override
	public boolean login(String name, String password) {
		return adao.login(name, password);
	}

}