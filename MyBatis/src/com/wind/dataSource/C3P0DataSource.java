package com.wind.dataSource;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 	1.自定义类 继承 UnpooledDataSourceFactory
 * 	2.写一个构造器。
 */
public class C3P0DataSource extends UnpooledDataSourceFactory{

	public C3P0DataSource() {
		this.dataSource = new ComboPooledDataSource();
	}
}
