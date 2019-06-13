package com.wind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wind.bean.SalesChance;
import com.wind.dao.SalesChanceMapper;
import com.wind.utils.Page;

@Service
public class SalesChanceService {

	@Autowired
	private SalesChanceMapper salesChanceMapper;
	
	@Transactional(readOnly = true)
	public Page<SalesChance> getList(String pageNo, int pageSize) {
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(pageNo);
		} catch (Exception e) {	}
		// 1.获取符合条件的总记录数
		int totalRecord = salesChanceMapper.getTotalRecord();
		// 2.创建Page类对象
		Page<SalesChance> page = new Page<SalesChance>(totalRecord, pageSize, pageNum);
		// 3.查询带了分页的数据列表，并设置到Page对象中。
		int firstIndex = page.getIndex() + 1;
		int endIndex = firstIndex + page.getPageSize();
		List<SalesChance> list = salesChanceMapper.getPageList(firstIndex, endIndex);
		page.setList(list);
		return page;
	}

	@Transactional(readOnly = false)
	public int deleteById(String id) {
		return salesChanceMapper.deleteById(id);
	}

	@Transactional(readOnly = true)
	public SalesChance getSalesChanceById(String id) {
		return salesChanceMapper.getSalesChanceById(id);
	}

	@Transactional(readOnly = false)
	public int saveSalesChance(SalesChance salesChance) {
		return salesChanceMapper.saveSalesChance(salesChance);
	}

}
