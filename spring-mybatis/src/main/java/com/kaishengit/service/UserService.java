package com.kaishengit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public void save(User user){
		userMapper.save(user);
	}
	
	public List<User> findByName(String userName){
		return userMapper.findByName(userName);
	}

}
