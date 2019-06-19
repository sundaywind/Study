package com.wind.test;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.catalina.connector.Request;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wind.bean.Authority;
import com.wind.bean.Role;
import com.wind.bean.SalesChance;
import com.wind.bean.User;
import com.wind.service.LoginService;
import com.wind.service.SalesChanceService;
import com.wind.utils.UserUtils;

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
	
	@Test
	public void Test04() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SalesChanceService bean = ac.getBean(SalesChanceService.class);
		List<User> users = bean.getUsers();
		SalesChance chance = bean.getChangeById("625");
	}
	
	@Test
	public void Test05() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SalesChanceService bean = ac.getBean(SalesChanceService.class);
		SalesChance chance = new SalesChance();
		chance.setId((long) 150);
		chance.setStatus(2);
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = new Date();
		try {
			date = sDateFormat.parse("2019-06-13");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		chance.setDesigneeDate(date);
		User designee = new User();
		designee.setId(((long) 21));
		chance.setDesignee(designee);
		bean.saveDispatch(chance);
	}
	
	@Test
	public void Test06() {
		// 获取当前登录人对象
		// HttpServletRequest request = new HttpServletRequestWrapper(request);
//		User user = UserUtils.getUser(request);
//		System.out.println(user);
	}
	
}
