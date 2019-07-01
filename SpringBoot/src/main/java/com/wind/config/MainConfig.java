package com.wind.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(value = {"com.wind.controller"})
public class MainConfig {
	// 启动类
	public static void main(String[] args) {
		// 静态main方法中，调用SpringBoot的run方法：第一个参数：@EnableAutoConfiguration标注的当前类的字节码
		SpringApplication.run(MainConfig.class, args);
	}
	/*
		将配置类和Controller类分离：
			启动status=404：
				配置了启动类，写了FirstController，但是没配置到容器中。
			怎么配置扫描包：
				在油@EnableAutoConfiguration类上加@ComponentScan(value = {"com.wind.controller"}) 扫描包注解。
	*/
}
