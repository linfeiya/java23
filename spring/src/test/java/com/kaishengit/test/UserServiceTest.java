package com.kaishengit.test;

import com.kaishengit.entity.User;
import com.kaishengit.service.DiDemo;
import com.kaishengit.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by linfeiya on 2017/7/7 0007.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void serviceTest(){
        User user = new User();
        user.setUser_name("");
        user.setDept_id(1);
        user.setUser_age(32);
        user.setAddress("郑州");
        user.setPassword("321");
        userService.save(user);
    }
}
