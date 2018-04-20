package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by dashuai on 2018/4/19.
 */
@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/sayHello")
    public String getString(){
        return restTemplate.getForObject("http://server-hi/sayHello",String.class);
    }
}
