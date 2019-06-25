package com.wind.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.wind.bean.OrderItems;
import com.wind.bean.User;
import com.wind.dao.OrderItemsMapper;
import com.wind.dao.UserMapper;

public class TestAll {

	@SuppressWarnings("unused")
	private SqlSession sqlSession;	// 这样写是非数据安全的，必须定义在方法中。
	/**
	 	SqlSession：是数据库和服务器的一次会话，不能定义在类中是非数据安全的，每次使用时要重新获取！
	 	JavaWeb的Session：是浏览器和服务器的一次会话。
	 */
	@Test
	// 入门第一个案例：
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
			User user = session.selectOne("org.mybatis.example.BlogMapper.selectUser", "websrvc");	// 有数据安全问题
			System.out.println(user);
		} finally {
			// 关闭session
			session.close();
		}
	}
	
	@Test
	// MyBatis使用接口式编程：
	public void test02() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		// 使用SqlSession对象中的getMapper()方法，指定接口的class文件，获取接口对象？（接口不能创建对象，创建的是接口的代理类对象）
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		System.out.println(mapper);	// org.apache.ibatis.binding.MapperProxy@12d3a4e9（Proxy：n. 代理人；委托书；代用品）
		User user = mapper.getUserByName("websrvc");	// 必须只能穿String类型，没有数据安全问题。
		System.out.println(user);
		// 关闭session
		openSession.close();
	}
	
	@Test
	// MyBatis基于注解的支持：
	public void test03() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		System.out.println(mapper);
		User user = mapper.getUserByNameZhuJie("websrvc");
		System.out.println(user);
		openSession.close();
	}
	
	@Test
	/* 
	 * 	insert，update 和 delete 必须开始事务：
	 * 		方法一：在SQL执行后使用openSession.commit();提交事务。
	 * 		方法二：在获取SqlSession时候，设置为true开启。（SqlSession openSession = sqlSessionFactory.openSession(true);）
	 */
	public void test04() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		System.out.println(mapper);
		User user = mapper.getUserByName("websrvc");
		System.out.println(user);
		openSession.commit();
		openSession.close();
	}
	
	@Test
	/* 
		关联关系：
			
	*/
	public void test05() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		OrderItemsMapper orderItemsMapper = openSession.getMapper(OrderItemsMapper.class);
		OrderItems orderItem = orderItemsMapper.getOrderItemsById(3);
		System.out.println(orderItem);
		openSession.close();
	}
}
