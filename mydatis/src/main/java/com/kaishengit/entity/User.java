package com.kaishengit.entity;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer deptId;
	private String userName;
	private Integer userAge;
	private String address;
	private String password;
	private Dept dept;
	
	public User(Integer deptId, String userName, Integer userAge, String address, String password) {
		super();
		this.deptId = deptId;
		this.userName = userName;
		this.userAge = userAge;
		this.address = address;
		this.password = password;
	}

	public User(){}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", deptId=" + deptId + ", userName=" + userName + ", userAge=" + userAge
				+ ", address=" + address + "]";
	}
	
	
	
}
