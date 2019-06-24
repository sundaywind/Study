package com.wind.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.wind.bean.User;

public class TestAll {

	@Test
	public void test01() throws IOException {
		// 根据mybatis-config.xml配置文件
		String resource = "mybatis-config.xml";
		// 将mybatis-config.xml配置文件加入到数据流中
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 利用输入流创建了sqlSessionFactory的Bean对象
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 根据sqlSessionFactory对象的openSession()方法，获取SqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// session调用selectOne()方法，第一个参数是MyBatisSQL映射文件（xml文件：namespace的值 + 参数值）
			User user = session.selectOne("org.mybatis.example.BlogMapper.selectUser", "websrvc");
			System.out.println(user);
		} finally {
			session.close();
		}
	}
}
