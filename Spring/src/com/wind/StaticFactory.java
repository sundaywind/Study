package com.wind;

public class StaticFactory {

	/*
	 * 	静态方法：可以类名直接调用静态方法，得到该静态方法的返回值。
	 * 	有什么好处？
	 */
	public static Book getBook() {
		Book book = new Book("三国演义", 16.8);
		return book;
	}
}
