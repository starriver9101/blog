package com.starriver.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starriver.blog.service.SuperService;

/**
 * @Name: SuperServiceImpl
 * @Description: SuperService 实现类（ 泛型：M 是  mapper(dao) 对象，T 是实体 ）
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
public class SuperServiceImpl<M extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T>, T> extends ServiceImpl<M, T> implements SuperService<T> {
}
