package com.wind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wind.bean.SalesChance;
import com.wind.service.SalesChanceService;
import com.wind.utils.Page;

@Controller
@RequestMapping(value = "/saleschance")
public class SalesChanceController {

	@Autowired
	private SalesChanceService salesChanceService;
	/*
	 * 	用请求方式来表示对资源请求的处理，REST风格。
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getSalesChance(String pageNo, ModelMap modeMap) {
		int pageSize = 2;
		Page<SalesChance> page= salesChanceService.getList(pageNo, pageSize);
		modeMap.addAttribute("page", page);
		return "/saleschance/list";
	}
	
	/* 
	 * 	添加修改的方法进来，判断id是否为空，为空时添加 不为空是修改
	 */
	@RequestMapping(value = {"/create"}, method = RequestMethod.GET)
	public String getSalesChance(String id, Model model) {
		if (id != null && id != "") {
			SalesChance salesChance = salesChanceService.getSalesChanceById(id);
			model.addAttribute("salesChance", salesChance);
		}
		return "/saleschance/form";
	}
	
	// 保存方法
	@RequestMapping(value = {"/save"}, method = RequestMethod.POST)
	public String getSalesChance(SalesChance salesChance, Model model, RedirectAttributes redirectAttributes) {
		int id = (int)(1+Math.random()*(1000-1+1));
		salesChance.setId((long) id);
		salesChance.setStatus(1);
		int count = salesChanceService.saveSalesChance(salesChance);
		if (count == 1) {
			addMessage(redirectAttributes, "添加成功");
		}else {
			addMessage(redirectAttributes, "添加失败！");
		}
		return "redirect:/saleschance/list";
	}
	
	/*
	  	将post请求转化为delete请求：
			1）需要借助于jQuery，取消get请求的默认行为。
			2）添加一个form表单，再在form表单中添加一个隐藏域  隐藏域的键为_method  值为delete、put。
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String getSalesChance(String id, RedirectAttributes redirectAttributes) {
		int count =  salesChanceService.deleteById(id);
		if (count == 1) {
			addMessage(redirectAttributes, "删除成功，客户转化失败！");
		}else {
			addMessage(redirectAttributes, "删除失败！");
		}
		return "redirect:/saleschance/list";
	}
	
	/**
	 * 添加Flash消息
	 * @param message
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		redirectAttributes.addFlashAttribute("message", sb.toString());
	}
}
