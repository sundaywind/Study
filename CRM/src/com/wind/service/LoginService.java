package com.wind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.wind.bean.User;
import com.wind.dao.LoginMapper;

@Service
public class LoginService {

	@Autowired
	private LoginMapper userMapper;
	
	public String verifyUserLogin(String name, String pwd) {
		RedirectAttributes att = new RedirectAttributesModelMap();
		User user = userMapper.verifyUserLogin(name, pwd);
		if (user != null) {
			att.addAttribute("msg", "欢迎回来！");
			return "Pass";
		}
		att.addAttribute("message", "用户名或密码错误");
		return "redirect:/index";
	}

}
