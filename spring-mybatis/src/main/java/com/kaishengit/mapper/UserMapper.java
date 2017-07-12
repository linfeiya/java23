package com.kaishengit.mapper;

import java.util.List;

import com.kaishengit.entity.User;

public interface UserMapper {
	void save(User user);
	List<User> findByName(String userName);
	List<User> findById(Integer id);
}
