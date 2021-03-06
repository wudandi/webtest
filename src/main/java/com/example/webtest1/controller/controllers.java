package com.example.webtest1.controller;


import com.example.webtest1.mapper.UserMapper;
import com.example.webtest1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class controllers{
    @Autowired
    private UserMapper userMapper;

    @GetMapping("register")
    public String reg() {
        return "management";
    }

    @RequestMapping("register")
    public String register(HttpServletRequest request, Map<String, Object> map) {
        String point = request.getParameter("point");
        String explanation = request.getParameter("explanation");
        User user = new User();
        user.setPoint(point);
        user.setExplanation(explanation);
        User user1 = userMapper.getuser(point);
        if (user1 != null) {
            map.put("msg1", "该知识点已经添加");
            return "management";
        } else {
            userMapper.adduser(user);
            return "content";
        }

    }

    @RequestMapping("getuser")
    public String getuser(HttpServletRequest request, Map<String, Object> map) {
        String point = request.getParameter("point");
        User user = userMapper.getuser(point);
        if (user != null) {
            map.put("msg", "此知识点已经记录，可直接查看！");
            return "management";
        } else {
            map.put("msg", "此知识点未记录，可添加记录！");
            return "management";
        }
    }

    @GetMapping("/login")
    public String info_login(){
        return "management";
    }
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

    @RequestMapping("updateuser")
    public String update(HttpServletRequest request, Map<String, Object> map) {
        String point = request.getParameter("point");
        String explanation = request.getParameter("explanation");
        User getuser = userMapper.getuser(point);
        if (getuser != null) {
            userMapper.updateuser(point, explanation);
            map.put("msg3", "该知识点更新成功！");
            return "content";
        } else {
            map.put("msg3", "该知识点不存在！");
            return "content";
        }
    }

    @RequestMapping("findAll")
    public String getallusers(HttpServletRequest request, Map<String, Object> map) {
        List<User> userList = userMapper.getallusers();
        int count = userList.size();
        List<User> newUserList = IntStream.range(0, count)
                .mapToObj(index -> new User(String.valueOf(index + 1), userList.get(index).getPoint(), userList.get(index).getExplanation()))
                .collect(Collectors.toList());
        map.put("userList", newUserList);
        return "findAll";
    }

}
