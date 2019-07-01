package com.wind.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication	// 相当于@EnableAutoConfiguration和@ComponentScan注解，但是只能扫描跟它同包或者子包下的@Controller类
public class DevelopConfig {

	public static void main(String[] args) {
		SpringApplication.run(DevelopConfig.class, args);
	}
}
