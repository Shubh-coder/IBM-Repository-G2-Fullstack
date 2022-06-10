package com.ibm.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan({"com.ibm.rest.*"})
@EnableWebMvc
public class IbmRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbmRestApplication.class, args);
	}

}
