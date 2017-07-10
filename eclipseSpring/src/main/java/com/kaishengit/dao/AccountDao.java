package com.kaishengit.dao;

public class AccountDao {

	private UserDao user;

	
	
	public AccountDao(UserDao accDao) {
		this.user = user;
	}

	public void setUser(UserDao acc) {
		this.user = user;
	}

	public void save(){
		System.out.println("accountDao------------");
	}

}
