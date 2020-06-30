package com.haora.user.service;

import com.haora.user.entity.User;
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
}
