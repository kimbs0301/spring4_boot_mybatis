package com.example.spring.logic.account.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.logic.account.dao.AccountDao;
import com.example.spring.logic.account.model.Account;

/**
 * @author gimbyeongsu
 * 
 */
@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(Account account) {
		sqlSessionTemplate.insert("account.insert", account);
	}

	@Override
	public void insertList(List<Account> accountList) {
		sqlSessionTemplate.insert("account.insertList", accountList);
	}

	@Override
	public void update(Account account) {
		sqlSessionTemplate.update("account.update", account);
	}

	@Override
	public void updateList(Map<String, Object> params) {
		sqlSessionTemplate.update("account.updateList", params);
	}

	@Override
	public void delete(int id) {
		sqlSessionTemplate.delete("account.delete", id);
	}

	@Override
	public Account get(int id) {
		return sqlSessionTemplate.selectOne("account.get", id);
	}

	@Override
	public List<Account> list() {
		return sqlSessionTemplate.selectList("account.list");
	}

	@Override
	public List<Account> listIn(List<Integer> idList) {
		return sqlSessionTemplate.selectList("account.list", idList);
	}
}
