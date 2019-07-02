package com.wind.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//其中@SpringBootApplication申明让spring boot自动给程序进行必要的配置，等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan
@SpringBootApplication
@MapperScan("com.wind.config.dao")
@EnableTransactionManagement	// 在主配置类上开启事务
public class DemoApp {
	public static void main(String[] args) {
		SpringApplication.run(DemoApp.class, args);
	}
}