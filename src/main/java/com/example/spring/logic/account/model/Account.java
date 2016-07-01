package com.example.spring.logic.account.model;

import java.util.Date;

/**
 * @author gimbyeongsu
 * 
 */
public class Account {
	private int id;
	private String name;
	private int value;
	private Date crtDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Date getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", value=" + value + ", crtDate=" + crtDate + "]";
	}
}
