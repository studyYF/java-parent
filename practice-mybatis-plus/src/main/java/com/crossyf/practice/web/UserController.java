package com.crossyf.practice.web;


import com.crossyf.practice.model.User;
import com.crossyf.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by YangFan.
 * @date 2019/11/14
 * 功能:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public User getUser(String id) {
        User user = userService.getUser(id);
        if (user != null) {
            return user;
        }
        return null;
    }
}
