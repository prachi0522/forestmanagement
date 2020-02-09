package com.capgimini.forestmanagementjdbc.testcase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgimini.forestmanagementjdbc.bean.AdminBean;
import com.capgimini.forestmanagementjdbc.dao.AdminDAO;
import com.capgimini.forestmanagementjdbc.dao.AdminDAOImpl;

class AdminDAOImplTest {

	private AdminBean adminBean = null;
	private AdminDAO dao = new AdminDAOImpl();

	@BeforeEach
	void load() {
		dao = new AdminDAOImpl();
	}

	@Test
	void testAddUser() {
		adminBean = new AdminBean();
		adminBean.setName("Susmita");
		adminBean.setPassword("root");
		boolean check = dao.login("Susmita", "root");
		assertEquals(check, false);
	}


}
