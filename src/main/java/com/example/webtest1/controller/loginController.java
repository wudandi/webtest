package com.example.webtest1.controller;

import com.example.webtest1.mapper.UserMapper;
import com.example.webtest1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class loginController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("login")
    public String login(HttpServletRequest request, Map<String, Object> map) {
        String point = request.getParameter("point");
        String explanation = request.getParameter("explanation");
        User user = userMapper.getuser(point);
        if (user != null) {
            map.put("msg2", point + ":" + user.getExplanation());
            return "content";
        } else {
            map.put("msg2", "该知识点不存在！");
            return "content";
        }

    }
}
