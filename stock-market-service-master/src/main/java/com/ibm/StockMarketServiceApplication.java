package com.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
@EnableSwagger2
public class StockMarketServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StockMarketServiceApplication.class, args);
	}
	
}
