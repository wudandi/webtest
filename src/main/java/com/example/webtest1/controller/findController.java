package com.example.webtest1.controller;

import com.example.webtest1.mapper.UserMapper;
import com.example.webtest1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class findController {
    @Autowired
    private UserMapper userMapper;

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
