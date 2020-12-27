package com.starriver.blog.mapper;

import com.starriver.blog.model.TExceptionLog;
import com.starriver.blog.model.TExceptionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TExceptionLogMapper {
    long countByExample(TExceptionLogExample example);

    int deleteByExample(TExceptionLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(TExceptionLog record);

    int insertSelective(TExceptionLog record);

    List<TExceptionLog> selectByExampleWithBLOBs(TExceptionLogExample example);

    List<TExceptionLog> selectByExample(TExceptionLogExample example);

    TExceptionLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TExceptionLog record, @Param("example") TExceptionLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TExceptionLog record, @Param("example") TExceptionLogExample example);

    int updateByExample(@Param("record") TExceptionLog record, @Param("example") TExceptionLogExample example);

    int updateByPrimaryKeySelective(TExceptionLog record);

    int updateByPrimaryKeyWithBLOBs(TExceptionLog record);

    int updateByPrimaryKey(TExceptionLog record);
}