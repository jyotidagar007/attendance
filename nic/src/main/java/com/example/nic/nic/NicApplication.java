package com.example.nic.nic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NicApplication {

	public static void main(String[] args) {
		SpringApplication.run(NicApplication.class, args);
	}

}
