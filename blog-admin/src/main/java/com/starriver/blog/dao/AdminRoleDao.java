package com.starriver.blog.dao;

import com.starriver.blog.model.Menu;
import com.starriver.blog.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRoleDao {
    /**
     * 条件查询订单
     */
    Role getRoleByAdminId(@Param("adminId") String adminId);


    List<Menu> getMenuByIds(@Param("menuIds") String[] menuIds);
}
