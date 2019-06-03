package com.wind;
/*
 * 	实例工厂：通过实例工厂的普通方法获取一个Bean对象
 */
public class InstanceFactory {

	public Book getBook() {
		Book book = new Book("西游记", 15.6);
		return book;
	}
}
