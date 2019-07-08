package com.skilldistillery.toolboxmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.skilldistillery.toolbox")//dont know what is suppose to be here
public class MvCbootToolboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvCbootToolboxApplication.class, args);
	}

}
