package com.starriver.blog.mapper;

import com.starriver.blog.model.TWebVisitLog;
import com.starriver.blog.model.TWebVisitLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWebVisitLogMapper {
    long countByExample(TWebVisitLogExample example);

    int deleteByExample(TWebVisitLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(TWebVisitLog record);

    int insertSelective(TWebVisitLog record);

    List<TWebVisitLog> selectByExample(TWebVisitLogExample example);

    TWebVisitLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TWebVisitLog record, @Param("example") TWebVisitLogExample example);

    int updateByExample(@Param("record") TWebVisitLog record, @Param("example") TWebVisitLogExample example);

    int updateByPrimaryKeySelective(TWebVisitLog record);

    int updateByPrimaryKey(TWebVisitLog record);
}