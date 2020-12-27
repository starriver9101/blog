package com.starriver.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Name: MyBatisConfig
 * @Description: MyBatisConfig
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.starriver.blog.mapper","com.starriver.blog.dao"})
public class MyBatisConfig {
}