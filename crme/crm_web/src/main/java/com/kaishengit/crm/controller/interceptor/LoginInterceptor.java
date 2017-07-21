package com.kaishengit.crm.controller.interceptor;

import com.kaishengit.crm.entity.Account;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by linfeiya on 2017/7/19 0019.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if (requestURI.startsWith("/static")){
            return true;
        }
        if("/".equals(requestURI)){
            return true;
        } else {
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("curr_user");
            if (account == null) {
                response.sendRedirect("/");
                return false;
            }
                return true;
        }
    }

}
