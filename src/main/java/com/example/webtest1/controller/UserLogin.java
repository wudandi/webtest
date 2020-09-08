package com.example.webtest1.controller;

import com.example.webtest1.mapper.LoginMapper;
import com.example.webtest1.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserLogin {
    @Autowired
    private LoginMapper loginMapper;

    @GetMapping("/userlogin")
    public String login(){
        return "UserLogin";
    }

    @RequestMapping("/userlogin")
    public String userlogin(HttpServletRequest request, Map<String,Object> map){

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Login loginuser = loginMapper.userlogin(username, password);

        if(loginuser!=null){
            map.put("msg7","the user "+loginuser+" login");
            return "management";
        }
        else{
            map.put("msg7","用户名或密码错误，请重试！");
            return "UserLogin";
        }
    }
}
