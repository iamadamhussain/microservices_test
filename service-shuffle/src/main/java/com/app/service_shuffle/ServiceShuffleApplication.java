package com.app.service_shuffle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceShuffleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceShuffleApplication.class, args);
	}

}
