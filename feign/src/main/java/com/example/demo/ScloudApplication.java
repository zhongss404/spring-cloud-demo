package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class ScloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScloudApplication.class, args);
	}

	@Autowired
	private HiService hiService;

	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	public String sayHi(){
		return hiService.sayHiFromOneClient();
	}
}
