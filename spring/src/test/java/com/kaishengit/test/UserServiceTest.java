package com.kaishengit.test;

import com.kaishengit.service.DiDemo;
import com.kaishengit.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by linfeiya on 2017/7/7 0007.
 */
public class UserServiceTest {
    @Test
    public void serviceTest(){
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("service");
     /*   DiDemo diDemo = (DiDemo) context.getBean("diDemo");
        diDemo.show();*/
        userService.save();
    }
}
