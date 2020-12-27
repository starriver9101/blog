package com.starriver.blog.service;

import com.starriver.blog.dto.AdminParam;
import com.starriver.blog.model.Admin;
import com.starriver.blog.model.Menu;
import com.starriver.blog.model.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Name: AdminService
 * @Description: 后台管理员Service
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
public interface AdminService {
    /**
     * 根据用户名获取后台管理员
     */
    Admin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    Admin register(AdminParam umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 刷新token的功能
     * @param oldToken 旧的token
     */
    String refreshToken(String oldToken);

    /**
     * 根据用户id获取用户
     */
    Admin selectByPrimaryKey(Long id);

    /**
     * 根据用户名或昵称分页查询用户
     */
    List<Admin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改指定用户信息
     */
    int update(Long id, Admin admin);

    /**
     * 删除指定用户
     */
    int delete(Long id);

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 修改密码
     */
    int updatePassword(AdminParam umsAdminParam);

    /**
     * 获取用户信息
     */
//    UserDetails loadUserByUsername(String username);

    /**
     * 获取用户信息
     */
//    void addOnlineAdmin(Admin admin, String token, String roleName);

    Role getRoleByAdminId(String adminId);

    List<Menu> getMenuByIds(String[] menuIds);
}