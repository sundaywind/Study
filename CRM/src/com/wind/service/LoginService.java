package com.wind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wind.bean.User;
import com.wind.dao.LoginMapper;

@Service
public class LoginService {

	@Autowired
	private LoginMapper userMapper;
	
	public User verifyUserLogin(String name, String pwd) {
		User user = userMapper.verifyUserLogin(name, pwd);
		return user;
	}

}
