package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Configuration
public class NewDocApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(NewDocApplication.class, args);
	}

}
