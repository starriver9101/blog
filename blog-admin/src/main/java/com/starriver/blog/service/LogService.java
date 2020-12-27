package com.starriver.blog.service;

import com.github.pagehelper.PageInfo;
import com.starriver.blog.model.ExceptionLog;
import com.starriver.blog.model.SysLog;
import com.starriver.blog.model.WebVisitLog;

import java.util.List;

/**
 * @Name: LogService
 * @Description: LogService
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
public interface LogService{
    PageInfo<ExceptionLog> getExceptionLogList(Integer pageNum, Integer pageSize);

    PageInfo<SysLog> getSysLogList(Integer pageNum, Integer pageSize);

    PageInfo<WebVisitLog> getWebVisitLogList(Integer pageNum, Integer pageSize);
}
