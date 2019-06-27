package com.offcn.crm.dao;

import com.offcn.crm.bean.SysDic;
import com.offcn.crm.bean.SysDicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDicMapper {
    int countByExample(SysDicExample example);

    int deleteByExample(SysDicExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(SysDic record);

    int insertSelective(SysDic record);

    List<SysDic> selectByExample(SysDicExample example);

    SysDic selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") SysDic record, @Param("example") SysDicExample example);

    int updateByExample(@Param("record") SysDic record, @Param("example") SysDicExample example);

    int updateByPrimaryKeySelective(SysDic record);

    int updateByPrimaryKey(SysDic record);
}