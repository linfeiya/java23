package com.kaishengit.service;

import com.kaishengit.dao.UserDao;

/**
 * Created by linfeiya on 2017/7/7 0007.
 */
public class UserService {
    private UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public void save(){
       dao.save();
    }
}
