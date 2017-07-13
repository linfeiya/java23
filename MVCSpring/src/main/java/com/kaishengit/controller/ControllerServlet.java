package com.kaishengit.controller;

import com.kaishengit.entity.User;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String User(){
        return "list";
    }
    @RequestMapping(method = RequestMethod.GET)
    public String add(){
        System.out.println("user_____");
        return "show";
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
 /* @RequestMapping(value = "name",method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("name" ,"jack");
        return "user";
    }*/
   /* @GetMapping
    public ModelAndView list(@RequestParam(defaultValue = "1",required = false)int page){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("list");
        mav.addObject("name","张三");
        return mav;
    }*/
    @GetMapping(value = "/validate/{userName}",
            produces = "text/html;charset=UTF-8")
    @ResponseBody
   public String validateUser(@PathVariable String userName){
        if("tom".equals(userName)){
            return "该账号已被占用";
        } else {
            return "可以使用";
        }
   }
   @GetMapping("/api/show")
   @ResponseBody
    public User showUser(){
        User user = new User();
        user.setId(1);
        user.setUserName("tom");
        user.setAddress("北京");

        return user;
    }
    @ResponseBody
    @GetMapping(value = "/api/shows")
    public List<User> showUserList(){
        User user = new User();
        user.setId(1);
        user.setUserName("tom");
        user.setAddress("北京");

        User user1 = new User();
        user1.setId(2);
        user1.setUserName("jack");
        user1.setAddress("深圳");
       List<User> userList = Arrays.asList(user,user1);
       return userList;

    }
    @GetMapping("/save")
    public String save(){
        return "save";
    }
    @PostMapping("/save")
    public String save(User user, String zipCode, RedirectAttributes redirectAttributes){
        System.out.println("userName : " + user.getUserName() + " address : " + user.getAddress() + " zipCode : " + zipCode);
        redirectAttributes.addFlashAttribute("message","保存成功");
        return "redirect:/user/save";
    }
    @PostMapping("/upload")
    public String upload(MultipartFile doc, String docName) {
        System.out.println("DocName:" + docName);

        if(!doc.isEmpty()) {
            System.out.println(doc.getName()); //表单控件名称
            System.out.println(doc.getOriginalFilename()); //文件名称
            System.out.println(doc.getSize());//文件大小
            System.out.println(doc.getContentType());//文件类型MIMEType

            try {
                InputStream inputStream = doc.getInputStream();
                OutputStream outputStream = new FileOutputStream(new File("F:/upload", doc.getOriginalFilename()));
                IOUtils.copy(inputStream, outputStream);
                outputStream.flush();
                outputStream.close();
                inputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return "redirect:/user/save";
    }

}
