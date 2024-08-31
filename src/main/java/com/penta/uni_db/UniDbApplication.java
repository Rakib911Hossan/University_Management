package com.penta.uni_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
public class UniDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniDbApplication.class, args);
	}

}



