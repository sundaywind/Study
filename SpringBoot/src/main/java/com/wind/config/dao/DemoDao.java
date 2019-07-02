package com.wind.config.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wind.config.bean.Demo;
 
/**
 * 	使用JdbcTemplate操作数据库。
	关键点：
		1、@Repository注解，标示DAO类
		2、@Resource注解引入JdbcTemplate对象。
		3、框架引入：spring-boot-starter-jdbc依赖后，可以直接生成JdbcTemplate对象。
*/
@Repository
public class DemoDao {
   
    @Resource
    private JdbcTemplate jdbcTemplate;
   
    /**
 		通过id获取demo对象.
    */
    public Demo getById(long id){
       String sql = "select *from Demo where id=?";
       RowMapper<Demo> rowMapper = new BeanPropertyRowMapper<Demo>(Demo.class);
       return jdbcTemplate.queryForObject(sql, rowMapper,id);
    }
}