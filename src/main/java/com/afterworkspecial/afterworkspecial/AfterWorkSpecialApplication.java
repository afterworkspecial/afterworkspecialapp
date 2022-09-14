package com.afterworkspecial.afterworkspecial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class AfterWorkSpecialApplication {

	public static void main(String[] args) {
		SpringApplication.run(AfterWorkSpecialApplication.class, args);
	}

}
