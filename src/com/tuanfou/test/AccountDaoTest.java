package com.tuanfou.test;

import com.tuanfou.dao.AccountDao;
import com.tuanfou.pojo.Account;
import com.tuanfou.service.UserService;


public class AccountDaoTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Account account = new Account();
//		account.setId(3);
//		account.setBalance(100);
//		
//		AccountDao accountDao = new AccountDao();
//		accountDao.update(account);
		AccountDao accountDao = new AccountDao();
		Account account = new Account();
		account.setBalance(0);
		accountDao.add(account);
		System.out.println(account.getId());
	}
}
