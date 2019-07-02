package com.wind.config.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wind.config.bean.Demo;
import com.wind.config.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Resource
    private DemoService demoService;   
    /**
     * 测试查询方法.
     */
    //地址：http://127.0.0.1:8080/demo/getById?id=1234567
    @RequestMapping("/getById")
    public Demo getById(long id){
       return demoService.getById(id);
    }
}