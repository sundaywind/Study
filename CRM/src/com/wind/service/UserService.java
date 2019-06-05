package com.wind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wind.bean.User;
import com.wind.dao.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUserByName(String name) {
		return userMapper.getUserByName(name);
	}
}
