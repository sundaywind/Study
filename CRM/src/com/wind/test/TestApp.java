package com.wind.test;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	@Test
	public void Test01() throws SQLException {
		// 测试配置的数据源能否连接数据库
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = ac.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}
	
}
