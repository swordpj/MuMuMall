package com.imooc.mumumall.controller;

import com.imooc.mumumall.common.ApiRestResponse;
import com.imooc.mumumall.exception.ImoocMallException;
import com.imooc.mumumall.exception.ImoocMallExceptionEnum;
import com.imooc.mumumall.model.pojo.User;
import com.imooc.mumumall.service.UserService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/test")
    @ResponseBody
    public User personalPage() {
        return userService.getUser();
    }

    @PostMapping("/register")
    @ResponseBody
    public ApiRestResponse register(@RequestParam("username") String username,
                                    @RequestParam("password") String password)
            throws ImoocMallException, NoSuchAlgorithmException {
        if(StringUtils.isNullOrEmpty(username)) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_USER_NAME);
        }

        if(StringUtils.isNullOrEmpty(password)) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_PASSWORD);
        }

        if(password.length() < 8) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.PASSWORD_TOO_SHORT);
        }
        userService.register(username, password);
        return ApiRestResponse.success();

    }
}
