package com.wind.config.service;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wind.config.bean.Demo;
import com.wind.config.dao.DemoDao;

/**
 * 	提供Demo服务类.
	关键点：
		1、@Service注解标示Service类。
		2、@Resource注解，引入Dao对象。
 */
@Service
public class DemoService {
       
       @Resource
       private DemoDao demoDao;
      
      
       public Demo getById(long id){             
              return demoDao.getById(id);
       }
}