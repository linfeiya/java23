package com.kaishengit.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.dao.DestoryDao;
import com.kaishengit.dao.InitDao;
import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;

public class UserDaoTest {
	
	private ApplicationContext context;
	//private ClassPathXmlApplicationContext apt;
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
	@Test
	public void userDaoTest(){
	/*	
	 * //spring管理的类的对象在启动spring时就已经被创建
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		*/
		//set 注入
		AccountDao account = (AccountDao) context.getBean("accountDao");
		account.save();
		
		/*UserDao userDao = (UserDao) context.getBean("userDao");
		userDao.save();*/
	}
	
	@Test
	public void setAccount(){
		//set注入根据类型 注入
		AccountDao account = (AccountDao)context.getBean("accountDao");
		account.save();
	}
	
	@Test
	public void show(){
		User user = (User)context.getBean("user");
		user.show();
	}
	@Test
	public void byType(){
		/*DestoryDao desDao = (DestoryDao)context.getBean("destoryDao");
		*/
		/*InitDao inDao = (InitDao)context.getBean("inDao");*/
		
	}
	
}
