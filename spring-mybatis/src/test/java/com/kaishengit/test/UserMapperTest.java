package com.kaishengit.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;
	
	Logger logger = LoggerFactory.getLogger(UserMapper.class);
	@Test
	public void findById(){
		
		List<User> userList = userMapper.findById(19);
		for(User user : userList){
			
			System.out.println( user.getUserName() + "-->" + user.getAddress());
		}
	}
	
	@Test
	public void save(){
		User user = new User(1,"李四",21,"深圳","123456");
		userMapper.save(user);
		
	}
	
}
