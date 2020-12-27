package com.starriver.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.starriver.blog.mapper.ExceptionLogMapper;
import com.starriver.blog.mapper.SysLogMapper;
import com.starriver.blog.mapper.WebVisitLogMapper;
import com.starriver.blog.model.*;
import com.starriver.blog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Name: LogServiceImpl
 * @Description: LogServiceImpl
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private ExceptionLogMapper exceptionLogMapper;

    @Autowired
    private SysLogMapper sysLogMapper;

    @Autowired
    private WebVisitLogMapper webVisitLogMapper;


    @Override
    public PageInfo<ExceptionLog> getExceptionLogList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<ExceptionLog>(exceptionLogMapper.selectByExampleWithBLOBs(new ExceptionLogExample()));
    }

    @Override
    public PageInfo<SysLog> getSysLogList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<SysLog>(sysLogMapper.selectByExampleWithBLOBs(new SysLogExample()));
    }

    @Override
    public PageInfo<WebVisitLog> getWebVisitLogList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<WebVisitLog>(webVisitLogMapper.selectByExample(new WebVisitLogExample()));
    }
}
