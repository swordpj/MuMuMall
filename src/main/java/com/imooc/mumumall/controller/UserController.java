package com.imooc.mumumall.controller;

import com.imooc.mumumall.model.pojo.User;
import com.imooc.mumumall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/test")
    @ResponseBody
    public User personalPage() {
        return userService.getUser();
    }
}
