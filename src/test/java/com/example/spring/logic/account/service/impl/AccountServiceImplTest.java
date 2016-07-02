package com.example.spring.logic.account.service.impl;

import java.util.concurrent.TimeUnit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.junit.JunitConfig;
import com.example.spring.logic.account.service.AccountService;
import com.google.common.base.Stopwatch;

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
public class AccountServiceImplTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImplTest.class);

	@Autowired
	private AccountService accountService;

	@Test
	public void test1() throws Exception {
		accountService.test1();
	}

	@Test
	public void test2() throws Exception {
		Stopwatch stopwatch = Stopwatch.createStarted();
		accountService.test2();
		stopwatch.stop();
		LOGGER.debug("Elapsed time in Milliseconds => {}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
	}

	@Test
	public void test3() throws Exception {
		Stopwatch stopwatch = Stopwatch.createStarted();
		accountService.test3();
		stopwatch.stop();
		LOGGER.debug("Elapsed time in Milliseconds => {}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
	}
}
