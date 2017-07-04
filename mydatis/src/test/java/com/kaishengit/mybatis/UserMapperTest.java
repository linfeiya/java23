package com.kaishengit.mybatis;

import java.util.List;

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
	public void findById(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		//��̬����ģʽ���ӿ�ָ��ʵ����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findById(2);
		
		logger.debug("{}",user);
		sqlSession.close();
	}
	@Test
	public void save(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = new User();
		user.setUserName("С��");
		user.setUserAge(32);
		user.setAddress("�Ϻ�");
		userMapper.save(user);
		
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Test
	public void findAllLoadDept(){

		List<User> userList = userMapper.findAllLoadDept();
		for(User user : userList){
			logger.debug("{}-->{}",user.getUserName(),user.getUserAge(),user.getAddress());
		}
		
	}
}