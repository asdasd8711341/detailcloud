package com.gsn.springcloud1_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MisProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MisProviderApplication.class, args);
	}

}
