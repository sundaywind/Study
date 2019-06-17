package com.wind.controller;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.wind.bean.SalesChance;
import com.wind.service.SalesChanceService;
import com.wind.utils.Page;

@Controller
@RequestMapping(value = "/chance")
public class SalesChanceController {

	@Autowired
	private SalesChanceService salesChanceService;
	/*
	 * 	用请求方式来表示对资源请求的处理，REST风格。
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String getSalesChance(HttpServletRequest request, ModelMap modeMap, String pageNo) {
		/*
			优化1：
			方法参数太多，可以用Spring自带的工具类获取：（以什么开始）
				WebUtils.getParametersStartingWith(ServletRequest arg0, String arg1);
					Map<String, Object> parametersStartingWith = WebUtils.getParametersStartingWith(request, "search_");
					System.out.println(parametersStartingWith);
					控制台输入内容为：{LIKE_custName=科技, LIKE_title= 台, LIKE_contact=老师}
		*/		
		// 优化2：用Map封装下方法参数
		/*
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pageNo", pageNo);
		*/
		Map<String, Object> map = WebUtils.getParametersStartingWith(request, "search_");
		map.put("pageNo", pageNo);
		System.out.println(map.get("LIKE_title"));
		/*
			System.out.println(requestURI);	// /CRM/saleschance/list
			System.out.println(requestURL);	// http://localhost:8080/CRM/saleschance/list
			注意：如果是get请求 /CRM/saleschance/list?pageNo=3; 要从？那截串
		*/
		Page<SalesChance> page= salesChanceService.getList(map);
		page.setSearchStr(toPageSearchString(map));
		page.setPath(request.getRequestURI());
		modeMap.addAttribute("page", page);
		/*
			条件查询点下一页上一页的时候 查询条件就跑了，是因为查询条件没带到页面去：
				1）刚开始想的是在页面拼接查询参数，那很麻烦。
				2）后端拼接好条件查询的参数后 再传回后台：
					（1）值在map中 遍历map 拼接。
						这里有个问题 字符串的拼接：用 +号拼接字符串的话 一个+号会在内存空间中new一个对象，太消耗内存。为了优化性能 以后拼接字符串用StringBuffer！
							StringBuffer str = new StringBuffer();
							str.append("&search_").append(key).append("=").append(value);
					（2）好好看下Map遍历：
						for (Entry<String, Object> entry : map.entrySet()) {
							String key = entry.getKey();
							// 优化代码：我们只要查询条件map中值，如果map中的Key以LIKE开头才遍历 提高效率。
							if (key.startsWith("LIKE")) {
								Object value = entry.getValue();
								// 需要这样的值：&search_LIKE_custName=xxx&search_LIKE_title=xxx&search_LIKE_contact=xxx
								str.append("&search_").append(key).append("=").append(value);
							}
						}
		*/
		return "/saleschance/list";
	}
	
	private String toPageSearchString(Map<String, Object> map) {
		StringBuffer str = new StringBuffer();
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			// 优化代码：我们只要查询条件map中值，如果map中的Key以LIKE开头才遍历 提高效率。
			if (key.startsWith("LIKE")) {
				Object value = entry.getValue();
				// 需要这样的值：&search_LIKE_custName=xxx&search_LIKE_title=xxx&search_LIKE_contact=xxx
				str.append("&search_").append(key).append("=").append(value);
			}
		}
		return str.toString();
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
		return "redirect:/chance/list";
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
		return "redirect:/chance/list";
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
