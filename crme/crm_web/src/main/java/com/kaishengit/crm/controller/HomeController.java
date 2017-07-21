package com.kaishengit.crm.controller;

import com.kaishengit.crm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by linfeiya on 2017/7/19 0019.
 */
@Controller
public class HomeController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
