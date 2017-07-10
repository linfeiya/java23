package com.kaishengit.entity;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.kaishengit.dao.UserDao;

public class User {
	
	private Account account;
	private String name;
	private Integer age;
	private List<String> nameList;
	private Map<String,Account> userMap;
	private Properties pro;
	private Set<String> mySet;
	
	public void show(){
		System.out.println("名字：" + account.getNames() +"\n" + "年龄：" + account.getAddress());
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		for(String name : nameList){
			System.out.println(name);
		}
		
		for(Map.Entry<String,Account> entry : userMap.entrySet()){
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
		
		Enumeration keys = pro.propertyNames();
		
		while(keys.hasMoreElements()){
			String key = (String) keys.nextElement();
			String value = pro.getProperty(key);
			
			System.out.println(key + "-->" + value);
		}
		
		for(String acc : mySet) {
			System.out.println("mySet : " + acc);
		}
		
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	public void setAge(Integer age) {
		this.age = age;
	}


	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}


	public void setPro(Properties pro) {
		this.pro = pro;
	}

	public void setUserMap(Map<String, Account> userMap) {
		this.userMap = userMap;
	}


	public void setMySet(Set<String> mySet) {
		this.mySet = mySet;
	}
	
}
