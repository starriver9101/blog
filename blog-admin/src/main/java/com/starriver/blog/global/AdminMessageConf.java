package com.starriver.blog.global;

/**
 * @Name: AdminMessageConf
 * @Description: AdminMessageConf
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
public class AdminMessageConf extends  BaseMessageConf {
    public static final String LOGIN_ERROR = "用户名或密码错误，错误%d次后，账户将被锁定30分钟";
    public static final String LOGIN_ERROR_LOCK = "密码输错次数过多,已被锁定30分钟";
    public static final String NO_ROLE = "没有权限";

}
