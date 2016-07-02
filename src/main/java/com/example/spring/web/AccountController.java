package com.example.spring.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring.logic.account.service.AccountService;

/**
 * @author gimbyeongsu
 * 
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	public AccountController() {
		LOGGER.debug("생성자 AccountController()");
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> test(Map<String, Object> json) {
		LOGGER.debug("{}", json);

		accountService.test1();
		accountService.deleteAll();
		accountService.test2();
		accountService.deleteAll();
		accountService.test3();
		accountService.deleteAll();
		
		json.put("resultCode", "SUCCESS");
		return json;
	}
}
