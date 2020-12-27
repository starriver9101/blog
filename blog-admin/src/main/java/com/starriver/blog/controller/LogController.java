package com.starriver.blog.controller;

import com.github.pagehelper.PageInfo;
import com.starriver.blog.api.CommonPage;
import com.starriver.blog.api.CommonResult;
import com.starriver.blog.dto.TmpPage;
import com.starriver.blog.model.ExceptionLog;
import com.starriver.blog.model.SysLog;
import com.starriver.blog.model.WebVisitLog;
import com.starriver.blog.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Name: LogController
 * @Description: LogController
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
@RestController
@RequestMapping("/log")
@Api(value = "操作日志相关接口", tags = {"操作日志相关接口"})
public class LogController {

    @Autowired
    private LogService logService;

    @ApiOperation(value = "获取操作日志列表", notes = "获取操作日志列表")
    @PostMapping(value = "/getExceptionList")
    public CommonResult<TmpPage<ExceptionLog>> getExceptionlogList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        PageInfo<ExceptionLog> list = logService.getExceptionLogList(pageNum, pageSize);

        return CommonResult.success(new TmpPage<>(list));
    }

    @ApiOperation(value = "获取操作日志列表", notes = "获取操作日志列表")
    @PostMapping(value = "/getSysLogList")
    public CommonResult<TmpPage<SysLog>> getSysLogList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        PageInfo<SysLog> list = logService.getSysLogList(pageNum, pageSize);
        return CommonResult.success(new TmpPage<>(list));
    }

    @ApiOperation(value = "获取操作日志列表", notes = "获取操作日志列表")
    @PostMapping(value = "/getWebVisitLogList")
    public CommonResult<TmpPage<WebVisitLog>> getWebVisitLogList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        PageInfo<WebVisitLog> list = logService.getWebVisitLogList(pageNum, pageSize);
        return CommonResult.success(new TmpPage<>(list));
    }
}