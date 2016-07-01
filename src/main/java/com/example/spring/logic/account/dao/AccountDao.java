package com.example.spring.logic.account.dao;

import java.util.List;
import java.util.Map;

import com.example.spring.logic.account.model.Account;

/**
 * @author gimbyeongsu
 * 
 */
public interface AccountDao {
	public void insert(Account account);
	
	public void insertList(List<Account> accountList);

	public void update(Account account);
	
	public void updateList(Map<String, Object> params);

	public void delete(int id);

	public Account get(int id);

	public List<Account> list();

	public List<Account> listIn(List<Integer> idList);
}
