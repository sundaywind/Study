package com.wind.bean;

public class User {
	// 要和数据库表的字段保持一致，有下划线不对应的起别名 别名和实体类的属性保持一致。
	private String User;
	private String Password;
	
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
		return "User [User=" + User + ", Password=" + Password + "]";
	}
	
}
