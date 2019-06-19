package com.wind.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wind.bean.SalesChance;
import com.wind.bean.User;
import com.wind.service.PlanService;
import com.wind.utils.Page;

@Controller
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private PlanService planService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(String pageNo, Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		Long id = user.getId();
		Page<SalesChance> page = planService.getListByUserId(id, pageNo);
		model.addAttribute("page", page);
		return "/plan/list";
	}
	
}
