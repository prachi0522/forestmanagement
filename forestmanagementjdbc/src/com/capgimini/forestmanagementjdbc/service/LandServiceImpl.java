package com.capgimini.forestmanagementjdbc.service;

import java.util.List;

import com.capgimini.forestmanagementjdbc.bean.LandBean;
import com.capgimini.forestmanagementjdbc.dao.LandDAO;
import com.capgimini.forestmanagementjdbc.factory.LandDAOManagerFactory;

public class LandServiceImpl implements LandService{
	LandDAO dao=LandDAOManagerFactory.instanceOfLandDAOImpl();

	@Override
	public List<LandBean> getAllLands() {
		return dao.getAllLands();
	}

	@Override
	public boolean deleteLand(int Landid3) {
		return dao.deleteLand(Landid3);
	}

	@Override
	public boolean addLand(LandBean bean) {
		return dao.addLand(bean);
	}

	@Override
	public boolean modifyLand(LandBean bean) {
		return dao.modifyLand(bean);
	}

}
