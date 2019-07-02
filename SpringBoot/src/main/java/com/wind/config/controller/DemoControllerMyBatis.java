package com.wind.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wind.config.bean.Demo;
import com.wind.config.service.DemoServiceMyBatis;

@Controller
@RequestMapping("/demoMyBatis")
public class DemoControllerMyBatis {
    @Autowired
    private DemoServiceMyBatis demoServiceMyBatis;   
    /**
     * 测试查询方法.
     */
    //地址：http://127.0.0.1:8080/demoMyBatis/getDemoById?id=1234567
    @RequestMapping("/getDemoById")
    public ModelAndView getById(long id){
    	Demo demo = demoServiceMyBatis.getDemoById(id);
    	ModelAndView mv = new ModelAndView("demo");
    	mv.addObject("Demo", demo);
       return mv;
    }
}