package com.wind.config.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class SecondController {

	@GetMapping("/msg")
	@ResponseBody
	public Map<String, String> getMsg() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("bookName", "金瓶梅");
		map.put("price", "100");
		return map;
	}
}
