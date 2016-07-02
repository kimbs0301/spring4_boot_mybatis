package com.example.spring.logic.account.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.logic.account.dao.AccountDao;
import com.example.spring.logic.account.model.Account;
import com.example.spring.logic.account.service.AccountService;
import com.google.common.base.Stopwatch;

/**
 * @author gimbyeongsu
 * 
 */
@Service
public class AccountServiceImpl implements AccountService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountDao accountDao;

	public AccountServiceImpl() {
		LOGGER.debug("생성자 AccountServiceImpl()");
	}

	@Override
	public void test1() {
		Stopwatch stopwatch = Stopwatch.createStarted();

		List<Account> insertTestList = new ArrayList<>();
		Account account1 = new Account();
		insertTestList.add(account1);
		account1.setId(1);
		account1.setName("A");
		Account account2 = new Account();
		insertTestList.add(account2);
		account2.setId(2);
		account2.setName("B");
		Account account3 = new Account();
		insertTestList.add(account3);
		account3.setId(3);
		account3.setName("C");
		accountDao.insertList(insertTestList);

		for (Account account : accountDao.list()) {
			LOGGER.debug("{}", account);
		}
		LOGGER.debug("");
		stopwatch.stop();
		LOGGER.debug("Elapsed time in Milliseconds => {}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
		stopwatch.reset();
		stopwatch.start();

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

		stopwatch.stop();
		LOGGER.debug("Elapsed time in Milliseconds => {}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
	}

	@Override
	public void test2() {
		List<Account> insertTestList = new ArrayList<>();
		for (int i = 1; i < 2000; ++i) {
			Account account = new Account();
			insertTestList.add(account);

			account.setId(i);
			account.setName(UUID.randomUUID().toString());
		}

		for (Account account : insertTestList) {
			accountDao.insert(account);
		}

		List<Account> updateTestList = new ArrayList<>();
		for (int i = 1; i < 2000; ++i) {
			Account account = new Account();
			updateTestList.add(account);

			account.setId(i);
			account.setName(UUID.randomUUID().toString());
			account.setValue(i);
		}

		for (Account account : updateTestList) {
			accountDao.update(account);
		}

		// for (Account account : accountDao.list()) {
		// LOGGER.debug("{}", account);
		// }
	}

	@Override
	public void test3() {
		List<Account> insertTestList = new ArrayList<>();
		for (int i = 1; i < 1000; ++i) {
			Account account = new Account();
			insertTestList.add(account);

			account.setId(i);
			account.setName(UUID.randomUUID().toString());
		}

		accountDao.insertList(insertTestList);

		List<Account> updateTestList = new ArrayList<>();
		for (int i = 1; i < 1000; ++i) {
			Account account = new Account();
			updateTestList.add(account);

			account.setId(i);
			account.setName(UUID.randomUUID().toString());
			account.setValue(i);
		}

		Map<String, Object> params = new HashMap<>();
		params.put("value", 0);
		params.put("list", updateTestList);
		accountDao.updateList(params);

		// for (Account account : accountDao.list()) {
		// LOGGER.debug("{}", account);
		// }
	}
}
