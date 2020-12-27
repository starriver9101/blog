package com.starriver.blog.controller;

import com.starriver.blog.api.CommonResult;
import com.starriver.blog.model.Admin;
import com.starriver.blog.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chen
 * @describe DemoController
 * @date 2020/12/18
 */
@Api(tags = "DemoController", description = "用户管理示例接口")
@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @ApiOperation(value = "获取全部品牌列表")
    @RequestMapping(value = "/brand/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Admin>> getBrandList() {
        return  null;
//        return CommonResult.success(demoService.listAllAdmin());
    }
}

