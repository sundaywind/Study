package com.wind;

public class User {

	private String userName = "张三";
	private Integer age = 19;
	private boolean gender = false;
	private String eamil = "zhangsan@163.com";
	private String address = "陕西西安";
	
	public User() {
		System.out.println("User类的无参构造器！");
		System.out.println("调用的User的构造器！");
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + ", gender=" + gender + ", eamil=" + eamil + ", address="
				+ address + "]";
	}
	
	// 测试Bean对象的生命周期
	public void initMethod() {
		System.out.println("User对象初始化方法");
	}
	public void destroyMethod() {
		System.out.println("User对象的销毁方法");
	}
}
