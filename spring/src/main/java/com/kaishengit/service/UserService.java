package com.kaishengit.service;

import com.kaishengit.dao.DeptDao;
import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by linfeiya on 2017/7/7 0007.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private DeptDao deptDao;

  /*  public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }*/
    @Transactional
    public void save(User user) {
        userDao.save(user);
        userDao.update(user);

    }
}
