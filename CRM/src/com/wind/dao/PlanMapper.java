package com.wind.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wind.bean.SalesChance;

public interface PlanMapper {

	List<SalesChance> getListByUserId(@Param("id")Long id, @Param("firstIndex")int firstIndex, @Param("endIndex")int endIndex);

	int getTotalRecord(Long id);

}
