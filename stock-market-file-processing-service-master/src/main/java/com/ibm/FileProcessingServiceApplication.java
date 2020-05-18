package com.ibm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.service.FileProcessingService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableDiscoveryClient
@RestController
@EnableSwagger2
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FileProcessingServiceApplication {

	@Autowired
	FileProcessingService service;
	
	public static void main(String[] args) {
		SpringApplication.run(FileProcessingServiceApplication.class, args);
	}
    
    @Scheduled(fixedDelay = 200000)
    public void FileProcessJob() {
		service.processFile(null);
    }
}
