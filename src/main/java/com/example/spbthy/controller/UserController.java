package com.example.spbthy.controller;

import com.example.spbthy.mapper.UserMapper;
import com.example.spbthy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired(required = false)
    UserMapper userMapper;
    /**
     * 跳转到用户登录页面
     * @return 登录页面
     */
    @RequestMapping("/loginHtml")
    public String loginHtml(){
        return "userLogin";
    }
    /**
     * 跳转到用户注册页面
     * @return 注册页面
     */
    @RequestMapping("/registerPage")
    public String registerPage(){
        return "register";
    }
    /**
     * 获取用户名与密码，用户登录
     * @return 登录成功页面
     */
    @RequestMapping("/userLogin")
    public String userLogin(@RequestParam("name") String name, @RequestParam("password") String password, Model m){

        User u=userMapper.userLogin(name,password);
        if(u != null){
            m.addAttribute("u", u);
            return "redirect:listCategory";
        }
        return "loginError";
    }
    /**
     * 注册新用户
     * @return 注册结果
     */
    @RequestMapping("/register")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2,
                          @RequestParam("age") int age){
        if(!password.equals(password2)){
            return "registerError";
        }else {
            int res = userMapper.addUser(name,password,age);
            if(res == 0){
                return "registerError";
            }else {
                return "registerSuccess";
            }
        }
    }
}
