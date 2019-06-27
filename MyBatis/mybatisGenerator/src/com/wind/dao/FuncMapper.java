package com.wind.dao;

import com.wind.bean.Func;
import java.util.List;

public interface FuncMapper {
    int deleteByPrimaryKey(String name);

    int insert(Func record);

    Func selectByPrimaryKey(String name);

    List<Func> selectAll();

    int updateByPrimaryKey(Func record);
}