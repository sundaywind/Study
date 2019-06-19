package com.wind.dao;

import java.util.List;
import java.util.Map;

import com.wind.bean.SalesChance;
import com.wind.bean.User;

public interface SalesChanceMapper {

	// 接口中方法默认不写是public
	List<SalesChance> getList();

	int deleteById(String id);

	SalesChance getSalesChanceById(String id);

	int saveSalesChance(SalesChance salesChance);

	int getTotalRecord(Map<String, Object> map);

	List<SalesChance> getPageList(Map<String, Object> map);

	/**
	 * 	获取所有用户
	 * @return Users
	 */
	List<User> getUsers();

	/**
	 * 	返回SalesChance实体类对象（根据id 有值）
	 * @param id
	 * @return SalesChance
	 */
	SalesChance getChangeById(String id);

	/**
	 * 	指派chance给user
	 * @param chance
	 * @return int counts
	 */
	int saveDispatch(SalesChance chance);

}
