package com.habits.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@EnableConfigurationProperties
@PropertySource("classpath:habits.properties")
@ConfigurationProperties(prefix="habits.config")
public class HabitsConfig {
	
	@Getter @Setter
	private Map<String,String> categories;
	
	@Getter @Setter
	private String categorias;
	@Getter @Setter
	private String insertcat;

}
