package com.haora.user.controller;

import com.haora.user.entity.User;
import com.haora.user.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 注册用户
 */
@RestController
public class RegisterUserController {
    @Autowired
    ActivityService activityService;

    @PostMapping("/firstLoginActivity")
    public String userRegistration(@RequestBody User user){
        System.out.println("用户注册成功："+user.getId()+"  time: "+new Date());
        return activityService.userRegistration(user) + new Date();
    }
}
