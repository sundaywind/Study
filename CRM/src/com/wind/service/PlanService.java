package com.wind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wind.bean.SalesChance;
import com.wind.dao.PlanMapper;
import com.wind.utils.Page;

@Service
public class PlanService {

	@Autowired
	private PlanMapper planMapper;

	@Transactional(readOnly = true)
	public Page<SalesChance> getListByUserId(Long id, String pageNo) {
		// 1.设置当前页
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(pageNo);
		} catch (Exception e) {	}
		// 2.获取符合条件的总记录数
		int totalRecord = planMapper.getTotalRecord(id);
		// 3.创建Page类对象
		Page<SalesChance> page = new Page<SalesChance>(totalRecord, pageNum);
		// 4.查询带了分页的数据列表，并设置到Page对象中。
		int firstIndex = page.getIndex() + 1;
		int endIndex = firstIndex + page.getPageSize();
		 List<SalesChance> list = planMapper.getListByUserId(id, firstIndex, endIndex);
		 page.setList(list);
		 return page;
	}
	
	
}
