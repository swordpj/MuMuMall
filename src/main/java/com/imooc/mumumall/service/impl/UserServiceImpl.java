package com.imooc.mumumall.service.impl;

import com.imooc.mumumall.model.dao.UserMapper;
import com.imooc.mumumall.model.pojo.User;
import com.imooc.mumumall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(1);
    }
}
