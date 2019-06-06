package com.wind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wind.bean.User;
import com.wind.service.LoginService;
/*
 	RedirectAttributes：是Spring mvc 3.1版本之后出来的一个功能，专门用于重定向之后还能带参数跳转的。
	他有两种带参的方式：
		第一种： 
			attr.addAttribute("param", value);  
			这种方式就相当于重定向之后，在url后面拼接参数，这样在重定向之后的页面或者控制器再去获取url后面的参数就可以了，但这个方式因为是在url后面添加参数的方式，所以暴露了参数，有风险！这样就相当于：return "redirect:/index?name=123&success=success"
		第二种： 
			attr.addFlashAttribute("param", value);
			这种方式也能达到重新向带参，而且能隐藏参数，其原理就是放到session中，session在跳到页面后马上移除对象。所以你刷新一下后这个值就会丢掉。
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String goHome(@RequestParam(value = "username")String name, @RequestParam("password")String pwd, Model model, RedirectAttributes  addAttribute) {
		if (name != null && name != "" && pwd != null && pwd != "") {
			User user = loginService.verifyUserLogin(name, pwd);
			if (user != null) {
				model.addAttribute("msg", "登陆成功！");
				return "view/home";
			}
		}
		addAttribute.addAttribute("message", "用户名或密码不能为空");
		return "redirect:/index";
	}
}
