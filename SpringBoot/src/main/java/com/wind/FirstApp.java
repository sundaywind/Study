package com.wind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 			// 	相当于在类中的所有方法上加：Controller + ResponseBody注解。
@EnableAutoConfiguration	// （开启自动配置）作用是：标注这个类是一个配置类，该配置相当于一个容器（类似于我们原来使用Spring时候的配置文件）
public class FirstApp {

	/*
		@GetMapping		@RequestMapping + method = GET
		@PostMapping	@RequestMapping + method = POST
		@PutMapping		@RequestMapping + method = PUT
		@DeleteMapping	@RequestMapping + method = DELETE
	*/
	@RequestMapping("/")
	String home() {
		return "Hello World!世界 你好！";
	}
	
	// 启动类
	public static void main(String[] args) {
		// 静态main方法中，调用SpringBoot的run方法：第一个参数：@EnableAutoConfiguration 标注的当前类的字节码
		SpringApplication.run(FirstApp.class, args);
	}
	
	/*
		启动后：（右键main方法，Run As ---> SpringBoot App）
			Tomcat started on port(s): 8080 (http)
			o.a.c.c.C.[Tomcat].[localhost].[/]
		浏览器访问：http://localhost:8080/
	*/
}
