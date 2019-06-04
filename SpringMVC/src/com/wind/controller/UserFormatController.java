package com.wind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.bean.UserFormat;

@Controller
@RequestMapping("user")
public class UserFormatController {

	/*
	  	SpringMVC两个格式化标签（要用SpringMVC格式化标签 首先得在springmvc.xml文件中配置<mvc:annotation-driven/>）：
	  		1）	@DateTimeFormat(pattern="yyyy-MM-dd")
				private Date birthday;
			2）	@NumberFormat(pattern="###,###,###.##")
				private double salary;
	 */
	
	@RequestMapping("add")
	public String getUser(UserFormat user) {
		System.out.println(user);
		return "success";
	}
}
