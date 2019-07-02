package com.wind.config.service;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wind.config.bean.Demo;
import com.wind.config.dao.DemoDaoMyBatis;

/**
 * 	提供Demo服务类.
	关键点：
		1、@Service注解标示Service类。
		2、@Resource注解，引入Dao对象。
 */
@Service
public class DemoServiceMyBatis {
       
       @Resource
       private DemoDaoMyBatis demoDaoMyBatis;
       @Transactional(readOnly = true)
       public Demo getDemoById(long id){             
              return demoDaoMyBatis.getDemoById(id);
       }
}