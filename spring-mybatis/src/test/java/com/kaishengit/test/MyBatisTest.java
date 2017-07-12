package com.kaishengit.test;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
public class MyBatisTest {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
	@Test
	public void save(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User(2,"小孩",12,"深圳","123");
		userMapper.save(user);
		sqlSession.commit();
		sqlSession.close();
		logger.debug("你瞅啥");
	}
}
