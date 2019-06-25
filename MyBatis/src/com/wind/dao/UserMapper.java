package com.wind.dao;

import org.apache.ibatis.annotations.Select;

import com.wind.bean.User;

public interface UserMapper {

	public User getUserByName(String name);
	
	/*
		MyBatis基于注解的支持：没有XML映射文件，SQL直接写在注解后面。
			@Select("select * from `user` where `User` = #{id}")
			@Insert("")
			@Update("")
			@Delete("")
	*/
	@Select(value = {"select * from `user` where `User` = #{id}"})
	public User getUserByNameZhuJie(String name);
}
