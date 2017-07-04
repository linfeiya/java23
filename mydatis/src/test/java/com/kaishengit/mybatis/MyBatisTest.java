package com.kaishengit.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kaishengit.entity.User;

	
public class MyBatisTest {
	@Test
	public void first() throws Exception{
		//1.加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.创建 sqlSessionFactoryBuilder
		//3.创建 sqlSessionFactory
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//4.创建sqlSession
		SqlSession sqlSession = sessionFactory.openSession();
 		//5.操作sql数据库
		User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",1);
		System.out.println(user.getUserName() + "\t" + user.getAddress());
		
		//6.关闭sqlSession
		sqlSession.close();
	}
	@Test
	public void insert(){
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			User user = new User();
			user.setAddress("西安");
			user.setUserName("jack");
			user.setUserAge(17);
			
			sqlSession.insert("com.kaishengit.mapper.UserMapper.save",user);
			
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void update() throws Exception{
		
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",6);
		user.setAddress("郑州");
		user.setUserName("小张");
		user.setUserAge(20);
		sqlSession.update("com.kaishengit.mapper.UserMapper.update",user);
		//提交事务
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void delById() throws Exception{
		
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.selectOne("com.kaishengit.mapper.UserMapper.delById",1);
		
		sqlSession.close();
		
	}
	@Test
	public void delete() throws Exception{
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("com.kaishengit.mapper.UserMapper.delById",4);
		
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	@Test
	public void findAll() throws Exception{
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> userList = sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");
		
		for(User user : userList){
			System.out.println(user.getUserName());
			System.out.println(user.getAddress());
			System.out.println(user.getUserAge());
		}
		sqlSession.close();
	}
	
	
	
}
