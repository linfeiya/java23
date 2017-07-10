package com.kaishengit.service;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by linfeiya on 2017/7/10 0010.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AccountDao accountDao;

    public void save(){
        userDao.userSave();
        accountDao.accSave();
    }
    /*public UserService(UserDao userDao,AccountDao accountDao){
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }*/
}
