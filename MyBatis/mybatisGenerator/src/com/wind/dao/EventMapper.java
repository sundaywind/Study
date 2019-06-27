package com.wind.dao;

import com.wind.bean.Event;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventMapper {
    int deleteByPrimaryKey(@Param("db") String db, @Param("name") String name);

    int insert(Event record);

    Event selectByPrimaryKey(@Param("db") String db, @Param("name") String name);

    List<Event> selectAll();

    int updateByPrimaryKey(Event record);
}