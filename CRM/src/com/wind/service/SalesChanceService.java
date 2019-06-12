package com.wind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wind.bean.SalesChance;
import com.wind.dao.SalesChanceMapper;

@Service
public class SalesChanceService {

	@Autowired
	private SalesChanceMapper salesChanceMapper;
	
	@Transactional(readOnly = true)
	public List<SalesChance> getList() {
		return salesChanceMapper.getList();
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
