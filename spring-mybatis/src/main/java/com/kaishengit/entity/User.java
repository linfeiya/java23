package com.kaishengit.entity;

public class User {
	private Integer id;
	private	Integer deptId;
	private String userName;
	private Integer userAge;
	private String address;
	private String password;
	
	public User(){}
	
	
	public User(Integer deptId, String userName, Integer userAge, String address, String password) {
		super();
		this.deptId = deptId;
		this.userName = userName;
		this.userAge = userAge;
		this.address = address;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
