package com.wind.test;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wind.bean.Authority;
import com.wind.bean.Role;
import com.wind.bean.User;
import com.wind.service.LoginService;

public class TestApp {

	@SuppressWarnings("resource")
	@Test
	public void Test01() throws SQLException {
		// 测试配置的数据源能否连接数据库
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = ac.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}
	
	@Test
	public void Test02() {
		// 测试查询用户及角色、权限信息（我写的，垃圾！）
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginService user = ac.getBean(LoginService.class);
		System.out.println(user);
		User userLogin = user.verifyUserLogin("bcde", "4f6ed9e4ab25a6dac05933a8a0c5822ada8177e5");
		Role role = userLogin.getRole();
		System.out.println(role);
		List<Authority> authorities = role.getAuthorities();
		String displayName = "";
		String subdisplayName = "";
		String suburl = "";
		for (Authority authority : authorities) {
			displayName = authority.getDisplayName();
			List<Authority> subAuthorities = authority.getSubAuthorities();
			for (Authority srbauthority : subAuthorities) {
				subdisplayName = srbauthority.getDisplayName();
				suburl = srbauthority.getUrl();
			}
			System.out.println("父名：" + displayName + "；子名：" + subdisplayName + "；子URL：" + suburl);
		}
	}
	
	@Test
	public void Test03() {
		// 测试查询用户及角色、权限信息
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginService bean = ac.getBean(LoginService.class);
		User user = bean.verifyUserLogin("bcde", "4f6ed9e4ab25a6dac05933a8a0c5822ada8177e5");
		List<Authority> authorities = user.getRole().getAuthorities();
		for (Authority authority : authorities) {
			System.out.println(authority.getDisplayName() + "===" + authority.getParentAuthority().getDisplayName() + authority.getUrl());
		}
	}
	
}
