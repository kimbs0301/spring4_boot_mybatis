package com.example.spring.logic.account.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.logic.account.dao.AccountDao;
import com.example.spring.logic.account.model.Account;
import com.example.spring.logic.account.service.AccountService;

/**
 * @author gimbyeongsu
 * 
 */
@Service
public class AccountServiceImpl implements AccountService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountDao accountDao;

	@Override
	public void test() {
		List<Account> testList = new ArrayList<>();
		Account account1 = new Account();
		testList.add(account1);
		account1.setId(1);
		account1.setName("A");
		Account account2 = new Account();
		testList.add(account2);
		account2.setId(2);
		account2.setName("B");
		Account account3 = new Account();
		testList.add(account3);
		account3.setId(3);
		account3.setName("C");
		accountDao.insertList(testList);

		for (Account account : accountDao.list()) {
			LOGGER.debug("{}", account);
		}
		LOGGER.debug("");

		List<Account> updateTestList = new ArrayList<>();
		Account updateAccount1 = new Account();
		updateTestList.add(updateAccount1);
		updateAccount1.setId(1);
		updateAccount1.setName("AA");
		updateAccount1.setValue(1);
		Account updateAccount2 = new Account();
		updateTestList.add(updateAccount2);
		updateAccount2.setId(2);
		updateAccount2.setName("BB");
		updateAccount2.setValue(2);
		Account updateAccount3 = new Account();
		updateTestList.add(updateAccount3);
		updateAccount3.setId(3);
		updateAccount3.setName("CC");
		updateAccount3.setValue(3);

		Map<String, Object> params = new HashMap<>();
		params.put("value", 0);
		params.put("list", updateTestList);
		accountDao.updateList(params);

		List<Integer> idList = new ArrayList<>();
		idList.add(1);
		idList.add(2);
		idList.add(3);
		List<Account> list = accountDao.listIn(idList);
		for (Account account : list) {
			LOGGER.debug("{}", account);
		}
	}
}
