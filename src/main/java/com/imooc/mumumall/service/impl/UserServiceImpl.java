package com.imooc.mumumall.service.impl;

import com.imooc.mumumall.exception.ImoocMallException;
import com.imooc.mumumall.exception.ImoocMallExceptionEnum;
import com.imooc.mumumall.model.dao.UserMapper;
import com.imooc.mumumall.model.pojo.User;
import com.imooc.mumumall.service.UserService;
import com.imooc.mumumall.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(1);
    }

    @Override
    public void register(String userName, String password) throws ImoocMallException, NoSuchAlgorithmException {
        User result = userMapper.selectByName(userName);
        if(result != null) {
            throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXIST);
        }

        User user = new User();
        user.setUsername(userName);
        user.setPassword(MD5Utils.getMD5String(password));
        int count = userMapper.insertSelective(user);
        if(count == 0) {
            throw new ImoocMallException(ImoocMallExceptionEnum.INSERT_DATA_FAILED);
        }
    }
}
