package com.habits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class HabitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabitsApplication.class, args);
	}

}
