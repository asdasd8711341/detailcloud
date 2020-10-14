package com.gsn.springcloud1_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient   //启用服务发现客户端,以获取当前provider的注册信息
public class MisProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MisProviderApplication.class, args);
	}

}
