package com.example.spring.logic.account.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.spring.logic.account.dao.AccountDao;
import com.example.spring.logic.account.model.Account;

/**
 * @author gimbyeongsu
 * 
 */
@Repository
public class AccountDaoImpl implements AccountDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountDaoImpl.class);

	public AccountDaoImpl() {
		LOGGER.debug("생성자 AccountDaoImpl()");
	}

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate session;

	@Override
	public void insert(Account account) {
		session.insert("account.insert", account);
	}

	@Override
	public void insertList(List<Account> accountList) {
		session.insert("account.insertList", accountList);
	}

	@Override
	public void update(Account account) {
		session.update("account.update", account);
	}

	@Override
	public void updateList(Map<String, Object> params) {
		session.update("account.updateList", params);
	}

	@Override
	public void delete() {
		session.delete("account.deleteAll");
	}

	@Override
	public void delete(int id) {
		session.delete("account.delete", id);
	}

	@Override
	public Account get(int id) {
		return session.selectOne("account.get", id);
	}

	@Override
	public List<Account> list() {
		return session.selectList("account.list");
	}

	@Override
	public List<Account> listIn(List<Integer> idList) {
		return session.selectList("account.listIn", idList);
	}
}
