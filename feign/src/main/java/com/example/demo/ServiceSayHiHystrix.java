package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * Created by dashuai on 2018/4/23.
 *
 * 服务不可用时熔断器hystrix处理过程
 *
 */
@Component
public class ServiceSayHiHystrix implements HiService {
    @Override
    public String sayHiFromOneClient(){
        return "service is down";
    }
}
