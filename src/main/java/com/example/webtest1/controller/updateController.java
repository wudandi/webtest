package com.example.webtest1.controller;

import com.example.webtest1.mapper.UserMapper;
import com.example.webtest1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class updateController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("updateuser")
    public String update(HttpServletRequest request, Map<String, Object> map) {
        String point = request.getParameter("point");
        String explanation = request.getParameter("explanation");
        User getuser = userMapper.getuser(point);
        if (getuser != null) {
            userMapper.updateuser(point, explanation);
            map.put("msg3", "该知识点详细说明已更新！");
            return "content";
        } else {
            map.put("msg3", "该知识点不存在！");
            return "content";
        }
    }
}
