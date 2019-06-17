package com.wind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wind.dao.PlanMapper;

@Service
public class PlanService {

	@Autowired
	private PlanMapper planMapper;
	
	
}
