package com.wind.dao;

import java.util.List;

import com.wind.bean.SalesChance;

public interface SalesChanceMapper {

	// 接口中方法默认不写是public
	List<SalesChance> getList();

	int deleteById(String id);

	SalesChance getSalesChanceById(String id);

	int saveSalesChance(SalesChance salesChance);

}