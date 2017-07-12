package com.kaishengit.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaishengit.entity.User;
import com.kaishengit.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	@Test
	public void findByName(){
		List<User> userList = userService.findByName("jack");
		for(User user : userList){
			System.out.println(user.getUserName() + "-->" + user.getAddress());
		}
	}
}
