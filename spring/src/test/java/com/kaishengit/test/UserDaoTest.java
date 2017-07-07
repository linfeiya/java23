package com.kaishengit.test;

import com.kaishengit.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by linfeiya on 2017/7/7 0007.
 */
public class UserDaoTest {
    @Test
    public void save(){
        //创建spring容器
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取对象Bean
        UserDao userDao = (UserDao) applicationContext.getBean("com.kaishengit.dao.UserDao");

        applicationContext.close();
    }
}
