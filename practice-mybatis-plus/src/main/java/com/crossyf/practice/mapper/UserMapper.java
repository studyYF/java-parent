package com.crossyf.practice.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crossyf.practice.model.User;

/**
 * @author Created by YangFan.
 * @date 2019/11/14
 * 功能:
 */
public interface UserMapper extends BaseMapper<User> {

    User selectUser(String id);

}
