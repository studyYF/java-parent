package com.crossyf.practice.service.impl;


import com.crossyf.practice.mapper.UserMapper;
import com.crossyf.practice.model.User;
import com.crossyf.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Created by YangFan.
 * @date 2019/11/14
 * 功能:
 */
@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String id) {
        return userMapper.selectUser(id);
    }
}
