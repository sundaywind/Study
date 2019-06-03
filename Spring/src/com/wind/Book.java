package com.wind;

public class Book {
	int x;
	private String bookName;
	private double price;
	private User user;
	
	public Book() {
		System.out.println("Book类的无参构造器！");
	}
	public Book(String bookName, double price) {
		super();
		this.bookName = bookName;
		this.price = price;
	}
	// 全参构造器 属性注入，必须把无参构造器写出来 因为框架底层还是要无参构造器的。
	public Book(String bookName, double price, User user) {
		super();
		System.out.println("通过构造器赋值，会走我！ 01");
		this.bookName = bookName;
		this.price = price;
		this.user = user;
	}
	// 全参构造器 属性注入，必须把无参构造器写出来 因为框架底层还是要无参构造器的。
	public Book(User user, String bookName, Integer price) {
		super();
		System.out.println("通过构造器赋值，会走我！ 03");
		this.bookName = bookName;
		this.price = price;
		this.user = user;
	}
	// 全参构造器 属性注入，必须把无参构造器写出来 因为框架底层还是要无参构造器的。
		public Book(User user, String bookName, double price) {
			super();
			System.out.println("通过构造器赋值，会走我！ 02");
			this.bookName = bookName;
			this.price = price;
			this.user = user;
		}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		System.out.println("set属性注入是不是走我呢？");
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", price=" + price + ", user=" + user + "]";
	}
	
}
