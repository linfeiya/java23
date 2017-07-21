package com.kaishengit.crm.controller;

import com.kaishengit.crm.entity.Account;
import com.kaishengit.crm.service.AccountService;
import com.kaishengit.dto.AjaxResult;
import com.kaishengit.exception.AuthenticationException;
import com.kaishengit.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by linfeiya on 2017/7/19 0019.
 */
@Controller
public class LoginController {
    @Autowired
    private AccountService accountService;
    //登录页
    @GetMapping("/")
    public String login (){
        return "login";
    }

    @PostMapping("/")
    @ResponseBody
    public AjaxResult login(String mobile, String password, HttpSession httpSession){
        try {
            Account account = accountService.login(mobile, password);
            httpSession.setAttribute("curr_user", account);
            return AjaxResult.success();
        }catch (AuthenticationException ex){
            return AjaxResult.error(ex.getMessage());
        }
    }
    //个人设置
    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }
    //安全退出
    @GetMapping("/logout")
    public String loginout(HttpSession httpSession, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","已安全退出，请登录");
        httpSession.invalidate();
        return "login";
    }

    @PostMapping("/profile")
    @ResponseBody
    public AjaxResult profile(String oldPassword,String password,HttpSession httpSession){
        Account account = (Account) httpSession.getAttribute("curr_user");
        try {
            accountService.changePassword(oldPassword, password, account);
            //修改密码并重新登录
            httpSession.invalidate();
            return AjaxResult.success();
        }catch (ServiceException ex) {

            return AjaxResult.error(ex.getMessage());
        }
    }

}
