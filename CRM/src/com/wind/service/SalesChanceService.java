package com.wind.service;

import java.util.List;
import java.util.Map;

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
	public Page<SalesChance> getList(Map<String, Object> map) {
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(map.get("pageNo").toString());
		} catch (Exception e) {	}
		// 1.获取符合条件的总记录数
		int totalRecord = salesChanceMapper.getTotalRecord(map);
		// 2.创建Page类对象
		Page<SalesChance> page = new Page<SalesChance>(totalRecord, Integer.parseInt(map.get("pageSize").toString()), pageNum);
		// 3.查询带了分页的数据列表，并设置到Page对象中。
		int firstIndex = page.getIndex() + 1;
		int endIndex = firstIndex + page.getPageSize();
		map.put("firstIndex", firstIndex);
		map.put("endIndex", endIndex);
		List<SalesChance> list = salesChanceMapper.getPageList(map);
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
