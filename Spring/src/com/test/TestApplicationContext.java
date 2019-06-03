package com.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wind.Book;
import com.wind.User;

class TestApplicationContext {

	@SuppressWarnings("resource")
	@Test
	void test1() {
		/*
		 * 	获取Spring核心容器的两种方式：
		 * 		ClassPathXmlApplicationContext("applicationContext.xml");
		 * 		FileSystemXmlApplicationContext("F:\\Wind\\DevDocument\\applicationContext.xml");
		 * 		XmlBeanFactory的工厂模式（知道就行）。
		 */
		/*
		 * 	从Spring核心容器获取Bean对象的两种方式：
		 * 		通过类的字节码文件获取：User user1 = ac1.getBean(User.class);
		 * 		通过Bean对象id或name属性获取：User bean = (User) ac1.getBean("user01"); 
		 */
		/*
		 * 	Bean对象的创建时间：
		 * 		通过反射就可以根据全类名就可以创建一个对象。
		 * 		创建类的时候，会调用类的构造器。
		 * 		屏蔽创建完Spring核心容器的后面代码，控制台也能输出，就说明在加载Spring核心容器的时候就创建了。
		 * 
		 * 	创建的Bean对象是单利还是多利：
		 * 		创建对象就会调用对象的构造器，而不管getBean()几次，构造器只调用了一次。
		 * 	如果就想把Bean对象的创建变为多利的：
		 * 		通过bean标签的scope属性
		 * 
		 * 	Bean对象的生命周期：
		 * 		指Bean对象由创建到死亡的过程。
		 * 			怎么体现？
		 * 				1.在类中编写初始化和销毁方法
		 * 				2.在xml中配置 指定init和destroy方法
		 */
		// 接口（不能new对象，鼠标点上按Ctrl+T 查看结构，可以看到它们的关系，而ClassPathXmlApplicationContext 获取类路劲下的ApplicationContext的文件是class）
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ApplicationContext ac2 = new FileSystemXmlApplicationContext("F:\\Wind\\DevDocument\\applicationContext.xml");
//		User user2 = ac2.getBean(User.class);	// 先在applicationContext.xml中配置，
//		Object bean = ac1.getBean("user01");      // 根据id或name值，是String类型的。获取后不知道是什么类型，系统只能返回一个最大的Object。完后通过强转可用。
//		User user1 = (User) bean;
//		System.out.println(user2); // 输出对象的信息是用了对象中的toString()方法	
//		System.out.println(user1);
	}
	
	@Test
	void test2() {
		/*
		 * 	IOC：Inverse Of Control  反转控制
		 * 		指将对象的 创建 和 维护，交给Spring容器来管理。IOC是一种理念，我们只需配置类的描述信息。
		 * 	DI： Dependency Injection 依赖注入
		 * 		体现的是对象之间关系的维护。
		 */
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Book book = ac.getBean(Book.class);
		System.out.println(book);
	}
	
	@Test
	void test3() {
		/*
		 * 	Spring容器创建Bean对象的三种方式：
		 * 		1.无参构造器创建。（在xml中配置bean标签）（就以上写的）
		 * 		2.静态工厂。
		 * 		3.实例工厂。
		 */
		// 静态工厂
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object bean = ac.getBean("getBook");
		System.out.println(bean);
		// 实例工厂
		Object bean2 = ac.getBean("instanceGetBook");
		System.out.println(bean2);
	}
	
	@Test
	void test4() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object book01 = ac.getBean("book01");
		System.out.println(book01);
		Object book02 = ac.getBean("book02");
		System.out.println(book02);
		Object book03 = ac.getBean("book03");
		System.out.println(book03);
		Object book04 = ac.getBean("book04");
		System.out.println(book04);
	}
	
	@Test
	void test5() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object bean = ac.getBean("book05");
		System.out.println("book001" + bean);
	}
	
	@Test
	void test6() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object bean1 = ac.getBean("book001");
		System.out.println(bean1);
		Object bean2 = ac.getBean("book002");	// 在xml中加了abstract属性，创建对象会报错：org.springframework.beans.factory.BeanIsAbstractException: Error creating bean with name 'book002': Bean definition is abstract
		System.out.println("book002的partent属性继承的book001的值" + bean2);
	}
	
	@Test
	void test7() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object bean = ac.getBean("FlexibleBean01");
		System.out.println(bean);
		
	}

}
