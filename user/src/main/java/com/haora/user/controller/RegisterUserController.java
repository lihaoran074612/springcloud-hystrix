package com.haora.user.controller;

import com.haora.user.entity.User;
import com.haora.user.service.ActivityService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    /**
     * 正常处理
     * @param user
     * @return
     */
    @PostMapping("/firstLoginActivity")
    public String firstLoginActivity(@RequestBody User user){
        System.out.println("用户注册成功："+user.getId()+" Time: "+new Date());
        return activityService.userRegistration(user) + new Date();
    }

    /**
     * 超时设置
     * @param user
     * @return
     */
    @PostMapping("/timeOutActivity")
    public String timeOutActivity(@RequestBody User user){
        System.out.println("用户注册成功："+user.getId()+" Time: "+new Date());
        return activityService.timeOutActivity(user) + new Date();
    }

    /**
     * 降级处理
     * @param user
     * @return
     */
    @PostMapping("/fallbackActivity")
    public String userRegistration(@RequestBody User user){
        System.out.println("用户注册成功："+user.getId()+" Time: "+new Date());
        return activityService.fallbackActivity(user) + new Date();
    }
}
