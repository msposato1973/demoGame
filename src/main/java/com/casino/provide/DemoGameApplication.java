package com.casino.provide;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoGameApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoGameApplication.class);
	  
	
	public static void main(String[] args) {
		SpringApplication.run(DemoGameApplication.class, args);
	}

	
	
}
