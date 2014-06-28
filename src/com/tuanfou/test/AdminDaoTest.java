package com.tuanfou.test;

import com.tuanfou.dao.AdminDao;
import com.tuanfou.pojo.Admin;

public class AdminDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setId(1);
		admin.setPassword("admin");
		
		AdminDao adminDao = new AdminDao();
		adminDao.update(admin);
	}
}
