package com.wind.bean;

public class Address {

        // 我来自云端！
	
	private String province;
	private String city;
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Address [province=" + province + ", city=" + city + "]";
	}
	
}
