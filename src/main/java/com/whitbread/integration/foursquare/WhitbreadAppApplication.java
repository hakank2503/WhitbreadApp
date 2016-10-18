package com.whitbread.integration.foursquare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.whitbread.integration")
public class WhitbreadAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhitbreadAppApplication.class, args);
	}
}
