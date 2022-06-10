package com.ibm.rest.application;

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

public class IbmCrsG2SpringJdbcTemplatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbmCrsG2SpringJdbcTemplatesApplication.class, args);
	}

}
