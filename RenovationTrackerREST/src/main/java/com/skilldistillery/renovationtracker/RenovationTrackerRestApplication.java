package com.skilldistillery.renovationtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RenovationTrackerRestApplication extends SpringBootServletInitializer {

	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(RenovationTrackerRestApplication.class);
	  }
	
	public static void main(String[] args) {
		SpringApplication.run(RenovationTrackerRestApplication.class, args);
	}

}
