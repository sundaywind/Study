package com.wind.utils;

import java.util.List;

public class Page<T> {
	private List<T> list;		// 查询数据列表信息，数据库中查询得到。
	private int totalRecord;	// 总记录数，数据库中查到。
	
	// private int totalNumber;	// 总页数，通过计算得到。
	// private int index;		// 查询的起始索引，通过计算得到。
	
	private int pageSize = 1;		// 每页显示的条数，前端传过来的。（自定义的 可以看成是由前端传过来的）
	private int pageNo;			// 当前页，前端传过来的。
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalNumber() {
		/*
			总记录数		pageSize：每页显示几条		总页数
			   9			4						  3
			   8			4						  2
			   7			4						  2
			   6			4						  2
		*/
		if (getTotalRecord() % getPageSize() == 0) {	// 如果总记录数 % 每页显示的条数 整除
			return getTotalRecord() / getPageSize();
		}else {
			return getTotalRecord() / getPageSize() + 1;
		}
	}
	// 外界不能修改我的总页数，所以setTotalNumber不能留
	/*public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}*/
	public int getIndex() {
		/*
			当前页		pageSize：每页显示几条		数据库Limit起始索引（index）
			   9			4						  3
			   8			4						  2
			   7			4						  2
			   6			4						  2
			
		*	index = (当前页 - 1) * 每页显示几条
		*/
		return (getPageNo() - 1) * getPageSize();
	}
	// 同理总页数，外界不能修改。
	/*public void setIndex(int index) {
		this.index = index;
	}*/
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageNo() {
		if (pageNo < 1) {	// 在首页时候点击上一页，pageNo=0
			pageNo = 1;
		}
		if (pageNo > getTotalNumber()) {	// 在末页时候点击下一页，pageNo=总页数+1
			pageNo = getTotalNumber();
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public Page() {
		super();
	}
	
	public Page(int totalRecord, int pageNo) {
		super();
		this.totalRecord = totalRecord;
		this.pageNo = pageNo;
	}
	
}
