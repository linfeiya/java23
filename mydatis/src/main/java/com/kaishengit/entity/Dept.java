package com.kaishengit.entity;

import java.util.List;

public class Dept {
	private Integer id;
	private String deptName;
	private String deptPassword;
	public String getDeptPassword() {
		return deptPassword;
	}
	public void setDeptPassword(String deptPassword) {
		this.deptPassword = deptPassword;
	}
	private List<User> userList;
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
