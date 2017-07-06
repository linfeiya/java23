package com.kaishengit.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.kaishengit.entity.Dept;
import com.kaishengit.entity.User;
import com.kaishengit.mapper.DeptMapper;
import com.kaishengit.util.MybatisUtil;

public class DeptMapperTest {
	@Test
	public void findByIdLoadDept(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
		
		Dept dept = deptMapper.findByIdLoadMapper(3);
		System.out.println(dept.getDeptName() + "-->" + dept.getId());
		List<User> userList = dept.getUserList();
		for(User user : userList){
			System.out.println(user.getUserName() + "-->" + user.getId());
		}
		sqlSession.close();
	}
}
