package com.starriver.blog.service.impl;

import com.starriver.blog.mapper.RoleMapper;
import com.starriver.blog.model.Role;
import com.starriver.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name: RoleServiceImpl
 * @Description: RoleServiceImpl
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role selectByPrimaryKey(String id){
        return roleMapper.selectByPrimaryKey(id);
    }
}
