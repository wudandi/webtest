package com.example.webtest1.controller;

import com.example.webtest1.mapper.UserMapper;
import com.example.webtest1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class getController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("getuser")
    public String getuser(HttpServletRequest request, Map<String, Object> map) {
        String point = request.getParameter("point");
        User user = userMapper.getuser(point);
        if (user != null) {
            map.put("msg", "此知识点已经有了");
            return "management";
        } else {
            map.put("msg", "此知识点未记录，可添加记录！");
            return "management";
        }
    }
}
