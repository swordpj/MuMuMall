package com.imooc.mumumall.service;

import com.imooc.mumumall.exception.ImoocMallException;
import com.imooc.mumumall.model.pojo.User;

import java.security.NoSuchAlgorithmException;

public interface UserService {

    User getUser();

    void register(String userName, String password) throws ImoocMallException, NoSuchAlgorithmException;

}
