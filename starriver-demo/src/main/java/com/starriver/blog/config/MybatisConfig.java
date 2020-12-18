package com.starriver.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chen
 * @describe MybatisConfig
 * @date 2020/12/18
 */
@Configuration
@MapperScan("com.starriver.blog.mapper")
public class MybatisConfig {
}

