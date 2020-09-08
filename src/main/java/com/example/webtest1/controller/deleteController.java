package com.example.webtest1.controller;

import com.example.webtest1.mapper.UserMapper;
import com.example.webtest1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class deleteController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("deleteuser")
    public String deleteuser(HttpServletRequest request, Map<String, Object> map) {
        String point = request.getParameter("point");
        User getuser = userMapper.getuser(point);
        if (getuser != null) {
            userMapper.deleteuser(point);
            map.put("msg4", "该知识点已成功删除！");
            return "content";
        } else {
            map.put("msg4", "该知识点不存在！");
            return "content";
        }
    }
}
