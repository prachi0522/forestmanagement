package com.capgimini.forestmanagementjdbc.dao;

import com.capgimini.forestmanagementjdbc.bean.AdminBean;

public interface AdminDAO {
	
	public boolean login(String name , String password);

}