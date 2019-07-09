package com.skilldistillery.toolboxmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan("com.skilldistillery.toolbox") // dont know what is suppose to be here
public class MvCbootToolboxApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MvCbootToolboxApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MvCbootToolboxApplication.class, args);
	}

}
