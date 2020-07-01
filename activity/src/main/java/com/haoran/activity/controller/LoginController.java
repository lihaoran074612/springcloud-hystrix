package com.haoran.activity.controller;

import com.haoran.activity.entity.User;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 处理注册活动请求
 */
@RestController
public class LoginController {

    /**
     * 正常处理
     */
    @PostMapping("/firstLoginActivity")
    public String firstLoginActivity(@RequestBody User user){
        System.out.println("首次登录，发送优惠券成功："+user.getId());
        return "succ";
    }

    /**
     * 超时处理
     */
    @PostMapping("/timeOutActivity")
    public String timeOutActivity(@RequestBody User user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(RandomUtils.nextInt(5)+2);
        System.out.println("首次登录，发送优惠券成功："+user.getId());
        return "succ";
    }

    /**
     * 降级处理
     */
    @PostMapping("/fallbackActivity")
    public String fallbackActivity(@RequestBody User user) throws InterruptedException {
        System.out.println("首次登录，发送优惠券成功："+user.getId());
        return String.valueOf(1/0);
    }
}
