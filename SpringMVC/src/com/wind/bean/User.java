package com.wind.bean;

import java.util.Arrays;
import java.util.List;

import com.wind.bean.Address;

public class User {

	// 云端代码，测试！
	private String username;
	private String pwd;
	private int age;
	private String Email;
	private Address address;
	private String[] hobby;
	private List<Address> list;
	
	
	public List<Address> getList() {
		return list;
	}
	public void setList(List<Address> list) {
		this.list = list;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", pwd=" + pwd + ", age=" + age + ", Email=" + Email + ", address="
				+ address + ", hobby=" + Arrays.toString(hobby) + ", list=" + list + "]";
	}
	
}
