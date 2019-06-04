package com.wind.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class UserFormat {

	private String username;
	private Integer age;
	private boolean gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	@NumberFormat(pattern="###,###,###.##")
	private double salary;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "UserFormat [username=" + username + ", age=" + age + ", gender=" + gender + ", birthday=" + birthday
				+ ", salary=" + salary + "]";
	}
	
}
