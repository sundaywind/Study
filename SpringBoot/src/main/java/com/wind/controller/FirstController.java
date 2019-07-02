package com.wind.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class FirstController {

	// 将配置文件中的信息复制给某个属性或对象
	/*@Value("${server.context-path}")
	public String contextPath;
	@Value("${server.port}")
	public String port;*/

	@GetMapping("/msg")
	@ResponseBody
	public Map<String, String> getMsg() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("bookName", "齐天大圣");
		map.put("price", "18.8");
		return map;
	}
}
