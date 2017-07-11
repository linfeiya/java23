package com.kaishengit.test;

import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

/**
 * Created by linfeiya on 2017/7/7 0007.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void save(){
        User user = new User();
        user.setDept_id(2);
        user.setUser_name("张三");
        user.setUser_age(23);
        user.setAddress("济源");
        user.setPassword("123456");

        userDao.save(user);
    }
    @Test
    public void update(){
        User user = new User();
        user.setUser_name("小六");
        user.setId(15);
        userDao.update(user);
    }
    @Test
    public void  findAll(){

        List<User> userList = userDao.findAll();

        Assert.assertEquals(userList.size(),22);
    }
    @Test
    public void findById(){
        User user = userDao.findById(3);
        System.out.println(user.getUser_name()+"-->"+user.getId());
    }
    @Test
    public void findByName(){
        List<User> userList = userDao.findByName("jack");
        for(User user : userList){
            System.out.println(user.getUser_name()+"-->"+user.getAddress()+"--》"+user.getId());
        }
    }
    @Test
    public void findByAddress(){
        List<User> userList = userDao.findByAddress("北京");
        for(User user : userList){
            System.out.println(user.getUser_name()+"-->"+user.getAddress());
        }
    }
    @Test
    public void count(){
        Long count = userDao.count();
        Assert.assertEquals(count.intValue(),22);
    }
}
