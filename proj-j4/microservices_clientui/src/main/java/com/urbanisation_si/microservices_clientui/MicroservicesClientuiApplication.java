package com.urbanisation_si.microservices_clientui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@SpringBootApplication
//J4 - 4
@EnableFeignClients("com.urbanisation_si.microservices_clientui")
public class MicroservicesClientuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesClientuiApplication.class, args);
	}

}
