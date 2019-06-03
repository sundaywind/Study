package com.wind;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class FlexibleBean {

	private Object[] arr;
	private List list;
	private Set set;
	private Map map;
	private Properties properties;
	
	public Object[] getArr() {
		return arr;
	}
	public void setArr(Object[] arr) {
		this.arr = arr;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Set getSet() {
		return set;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	@Override
	public String toString() {
		return "FlexibleBean [arr=" + Arrays.toString(arr) + ", list=" + list + ", set=" + set + ", map=" + map
				+ ", properties=" + properties + "]";
	}
	
}
