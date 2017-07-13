package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by linfeiya on 2017/7/13 0013.
 */
@Controller
@RequestMapping("/user")
public class ControllerServlet {
    @GetMapping("/hello")
    public String show(){
        System.out.println("hello-------");
        return "hello";
    }
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String User(){
        return "home";
    }
    @RequestMapping(method = RequestMethod.GET)
    public String add(){
        System.out.println("user_____");
        return "home";
    }
    /*@GetMapping("/{id}")
    public String list(@PathVariable Integer id){
        System.out.println("hello___________");
        return "index";
    }*/
    @GetMapping("/{id:\\d+}")
    public String save(@PathVariable Integer id){
        System.out.println("ID : " + id);
        return "index";
    }
  /*  @GetMapping("/{className:[java\\d+]|[web\\d+]}/{name}")
    public String showUser(@PathVariable String className,@PathVariable String name){
        System.out.println("className : " + className);
        System.out.println("name : " + name);
        return "user";
    }*/
  @RequestMapping(value = "name",method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("name" ,"jack");
        return "user";
    }
    @GetMapping
    public ModelAndView list(@RequestParam(defaultValue = "1",required = false)int page){
        ModelAndView mav = new ModelAndView();
        mav.se
        return mav;
    }

}
