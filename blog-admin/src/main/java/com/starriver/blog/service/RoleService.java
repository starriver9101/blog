package com.starriver.blog.service;

import com.starriver.blog.model.Role;

/**
 * @Name: RoleService
 * @Description: RoleService
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
public interface RoleService {
    Role selectByPrimaryKey(String id);
}
