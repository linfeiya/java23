package com.kaishengit.crm.controller;

import com.kaishengit.crm.entity.Account;

import javax.servlet.http.HttpSession;

/**
 * Created by linfeiya on 2017/7/20 0020.
 */
public class BaseController {

    public Account getCurrUser(HttpSession session){
        return (Account) session.getAttribute("curr_user");
    }
}
