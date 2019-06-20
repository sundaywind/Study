package com.wind.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAll {

	@Test
	public void test01() {
		// SessionFactoryBean
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		ac.getBean("");
	}
	
	
}
