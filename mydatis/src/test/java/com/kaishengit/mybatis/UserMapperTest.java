package com.kaishengit.mybatis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.util.MybatisUtil;

public class UserMapperTest {

	private Logger logger = LoggerFactory.getLogger(UserMapperTest.class);
	private SqlSession sqlSession;
	private UserMapper userMapper;
	
	@Before
	public void before(){
		sqlSession = MybatisUtil.getSqlSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
	}
	@After
	public void after(){
		sqlSession.close();
	}
	@Test
	public void findAllLoadDept(){

		List<User> userList = userMapper.findAllLoadDept();
		for(User user : userList){
			logger.debug("{}-->{}-->{}",user.getUserName(),user.getUserName(),user.getAddress());
		}
		
	}
	@Test
	public void findAll(){
		List<User> userList = userMapper.findAllLoadDept();
		for(User user : userList){
			logger.debug("{}-->{}",user.getDept().getDeptName(),user.getUserName());
		}
		
	}
	
	@Test
	public void findById(){
		
		User user = userMapper.findById(2);
		
		logger.debug("{}",user);
		sqlSession.close();
	}
	@Test
	public void save(){
		
		User user = new User();
		user.setUserName("小明");
		user.setUserAge(32);
		user.setAddress("上海");
		userMapper.save(user);
		
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Test
	public void findIdByNameAndPassword(){
		
		User user = userMapper.findIdByNameAndPassword("tom", "123");
		System.out.println("ID : " + user.getId());
		sqlSession.close();
	}
	@Test
	public void findByMapParam(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "tom");
		map.put("password", "123");
		User user = userMapper.findByMapParam(map);
		System.out.println(user.getId());
		
	}
	@Test
	public void findMapParam(){
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "jack");
		map.put("password", "2222");
		
		User user = userMapper.findByMapParam(map);
		System.out.println(user.getId()+ "-->" +user.getAddress());
	}	
	@Test
	public void searchByNameAndAddress(){
		
		Map<String,Object> map = new HashMap<String, Object>();
		//map.put("name", "小明");
		map.put("address", "郑州");
		
		List<User> userList = userMapper.searchByNameAndAddress(map);
		for(User user :userList){
			System.out.println(user.getId()+ "-->" + user.getUserName());
		}
	}
	
	@Test
	public void delByIds(){
		
		List<Integer> idList = Arrays.asList(7,8);
		userMapper.delByIds(idList);
		
		sqlSession.commit();
	}
	@Test
	public void batchSave(){
		
		List<User> userList = Arrays.asList(new User(2,"张三",32,"焦作","123456"),
				new User(2,"王五",32,"焦作","123456"),new User(2,"李四",32,"焦作","123456"));
		
		userMapper.batchSave(userList);
		sqlSession.commit();
		for(User user : userList){
			System.out.println(user.getId());
		}
		
	}
	@Test
	public void findByNameAndPassowrd(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "张三");
		map.put("password", "123");
		
		List<User> userList = userMapper.findByNameAndPassword(map);
		for(User user: userList){
			
			System.out.println(user.getUserName()+ "-->" +user.getAddress());
		}
		
	}
	
	@Test
	public void secLevelCache(){
		SqlSession sqlSession1 = MybatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession1.getMapper(UserMapper.class);
		
		User user1 = userMapper.findById(15);
		
		System.out.println(user1.getUserName());
		sqlSession1.close();
		
		System.out.println("----------------------------");
		
		SqlSession sqlSession2 = MybatisUtil.getSqlSession();
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		User user2 = userMapper2.findById(15);
		System.out.println(user2.getUserName());
	}
	
	@Test
	public void firstLevelCache(){
		User user = userMapper.findById(16);
		User user2 = userMapper.findById(16);
		
		System.out.println(user.getUserName());
	}
	
}
