package com.tuanfou.test;

import com.tuanfou.dao.AccountDao;
import com.tuanfou.pojo.Account;


public class AccountDaoTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setId(3);
		account.setBalance(100);
		
		AccountDao accountDao = new AccountDao();
		accountDao.add(account);
		
	}
}
