package com.haora.user.service;

import com.haora.user.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActivityService {
    @Autowired
    RestTemplate restTemplate;

    public String userRegistration(User user) {
        return restTemplate.postForObject("http://activity/firstLoginActivity",user,String.class);
    }


    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String timeOutActivity(User user) {
        return restTemplate.postForObject("http://activity/timeOutActivity",user,String.class);
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String fallbackActivity(User user) {
        return restTemplate.postForObject("http://activity/fallbackActivity",user,String.class);
    }


    public String fallbackMethod(User user){
        return "服务器正忙，稍后再试";
    }
}
