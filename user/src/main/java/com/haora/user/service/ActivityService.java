package com.haora.user.service;

import com.haora.user.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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


    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds", value = "2000")
            }
    )
    public String timeOutActivity(User user) {
        return restTemplate.postForObject("http://activity/timeOutActivity",user,String.class);
    }

    public String fallbackActivity(User user) {
        return restTemplate.postForObject("http://activity/fallbackActivity",user,String.class);
    }
}
