package com.kaishengit.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kaishengit.entity.User;

public interface UserMapper {
	User findById(Integer id);
	void save(User user);
	void update(User user);
	void delById(Integer id);
	List<User> findAll();
	List<User> findAllLoadDept();
	void updateById(Integer id);
	User findIdByNameAndPassword(@Param("userName") String userName,
								@Param("password")	String password);
	
	User findByMapParam(Map<String,Object> params);
	
	List<User> searchByNameAndAddress(Map<String,Object> params);
	
	void delByIds(List<Integer> id);
	
	void batchSave(List<User> userList);
	
	List<User> findByNameAndPassword(Map<String,Object> params);
	
}
