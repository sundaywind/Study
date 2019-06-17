package com.wind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wind.service.PlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private PlanService planService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList() {
		
		return "/plan/list";
	}
	
}
