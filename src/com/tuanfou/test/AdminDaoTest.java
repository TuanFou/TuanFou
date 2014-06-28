package com.tuanfou.test;

import com.tuanfou.dao.AdminDao;
import com.tuanfou.pojo.Admin;

public class AdminDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		//admin.setEmployeeId("admin1");
		//admin.setPassword("admin");
		
		AdminDao adminDao = new AdminDao();
		//adminDao.add(admin);
		
		admin.setId(1);
		admin.setEmployeeId("admin1");
		admin.setPassword("admin1");
		adminDao.update(admin);
	}
}
