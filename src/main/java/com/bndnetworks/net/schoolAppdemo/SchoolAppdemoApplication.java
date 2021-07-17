package com.bndnetworks.net.schoolAppdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SchoolAppdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolAppdemoApplication.class, args);
	}

}
