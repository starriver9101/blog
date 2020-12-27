package com.starriver.blog.mapper;

import com.starriver.blog.model.WebVisitLog;
import com.starriver.blog.model.WebVisitLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebVisitLogMapper {
    long countByExample(WebVisitLogExample example);

    int deleteByExample(WebVisitLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebVisitLog record);

    int insertSelective(WebVisitLog record);

    List<WebVisitLog> selectByExample(WebVisitLogExample example);

    WebVisitLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebVisitLog record, @Param("example") WebVisitLogExample example);

    int updateByExample(@Param("record") WebVisitLog record, @Param("example") WebVisitLogExample example);

    int updateByPrimaryKeySelective(WebVisitLog record);

    int updateByPrimaryKey(WebVisitLog record);
}