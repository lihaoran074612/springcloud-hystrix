package com.haoran.activity.controller;

import com.haoran.activity.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 处理注册活动请求
 */
@RestController
public class LoginController {

    @PostMapping("/firstLoginActivity")
    public String firstLoginActivity(@RequestBody User user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(12);
        System.out.println("首次登录，发送优惠券成功："+user.getId());
        return "succ";
    }
}
