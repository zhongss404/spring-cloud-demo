package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dashuai on 2018/4/20.
 */
@FeignClient(value = "service-hi",fallback = ServiceSayHiHystrix.class)
public interface HiService {
    @RequestMapping(value = "/sayHi",method = RequestMethod.GET)
    String sayHiFromOneClient();
}
