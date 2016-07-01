package com.example.spring.logic.account.dao.impl;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.junit.JunitConfig;
import com.example.spring.logic.account.dao.AccountDao;
import com.example.spring.logic.account.model.Account;

/**
 * @author gimbyeongsu
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { JunitConfig.class })
@WebAppConfiguration
@ActiveProfiles(profiles = { "junit" })
@TestPropertySource(locations = "classpath:application-junit.properties")
@Transactional
public class AccountDaoImplTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountDaoImplTest.class);

	@Autowired
	private AccountDao accountDao;

	@Test
	@Rollback(false)
	public void test1_insert() throws Exception {
		Account account = new Account();
		account.setId(1);
		account.setName("KKK");
		account.setValue(100);
		accountDao.insert(account);
	}

	@Test
	@Rollback(false)
	public void test2_update() throws Exception {
		Account account = new Account();
		account.setId(1);
		account.setName("BBB");
		account.setValue(100);
		accountDao.update(account);
	}

	@Test
	@Rollback(false)
	public void test3_select_one() throws Exception {
		Account account = accountDao.get(1);
		LOGGER.debug("{}", account);
	}

	@Test
	@Rollback(false)
	public void test4_select_list() throws Exception {
		List<Account> accountList = accountDao.list();
		LOGGER.debug("{}", accountList);
	}

	@Test
	@Rollback(false)
	public void test5_delete() throws Exception {
		accountDao.delete(1);
	}
}
