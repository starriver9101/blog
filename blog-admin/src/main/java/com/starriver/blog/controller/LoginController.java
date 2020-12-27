package com.starriver.blog.controller;

import com.starriver.blog.*;
import com.starriver.blog.global.*;
import com.starriver.blog.model.Admin;
import com.starriver.blog.model.Menu;
import com.starriver.blog.model.Role;
import com.starriver.blog.service.AdminService;
import com.starriver.blog.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Name: LoginController
 * @Description: LoginController
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
@RestController
//@RefreshScope
@RequestMapping("/auth")
@Api(value = "登录相关接口", tags = {"登录相关接口"})
//@Slf4j
public class LoginController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisUtil redisUtil;


    @ApiOperation(value = "获取网站名称", notes = "获取网站名称", response = String.class)
    @GetMapping(value = "/getWebSiteName")
    public String getWebSiteName() {
        return ResultUtil.successWithData("starriver");
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/login")
    public String login(HttpServletRequest request,
                        @ApiParam(name = "username", value = "用户名或邮箱或手机号") @RequestParam(name = "username", required = false) String username,
                        @ApiParam(name = "password", value = "密码") @RequestParam(name = "password", required = false) String password,
                        @ApiParam(name = "isRememberMe", value = "是否记住账号密码") @RequestParam(name = "isRememberMe", required = false, defaultValue = "false") Boolean isRememberMe) {

        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return ResultUtil.result(AdminSysConf.ERROR, "账号或密码不能为空");
        }
        String ip = IpUtils.getIpAddr(request);
        String limitCount = redisUtil.get(AdminRedisConf.LOGIN_LIMIT + AdminRedisConf.SEGMENTATION + ip);
        if (!StringUtils.isEmpty(limitCount)) {
            Integer tempLimitCount = Integer.valueOf(limitCount);
            if (tempLimitCount >= 5) {
                return ResultUtil.result(AdminSysConf.ERROR, AdminMessageConf.LOGIN_ERROR_LOCK);
            }
        }
        Admin admin = adminService.getAdminByUsername(username);
        if(admin == null){
            return ResultUtil.result(AdminSysConf.ERROR, String.format(AdminMessageConf.LOGIN_ERROR, setLoginCommit(request)));
        }
        //验证密码
        boolean isPassword = password.equals(admin.getPassword());
        if (!isPassword) {
            return ResultUtil.result(AdminSysConf.ERROR, String.format(AdminMessageConf.LOGIN_ERROR, setLoginCommit(request)));
        }
        Role role = roleService.selectByPrimaryKey(admin.getRoleId());
        if(role == null){
            return ResultUtil.result(AdminSysConf.ERROR, AdminMessageConf.NO_ROLE);
        }

        return ResultUtil.result(AdminSysConf.SUCCESS, "star");
    }

    @ApiOperation(value = "用户信息", notes = "用户信息", response = String.class)
    @GetMapping(value = "/info")
    public String info(HttpServletRequest request,
                       @ApiParam(name = "token", value = "token令牌", required = false) @RequestParam(name = "token", required = false) String token) {

        Map<String, Object> map = new HashMap<>();
        Admin admin = adminService.getAdminByUsername("admin");
        map.put(AdminSysConf.TOKEN, token);
        Collection<Role> roleList = new ArrayList<>();
        roleList.add(roleService.selectByPrimaryKey(admin.getRoleId()));
        map.put(AdminSysConf.ROLES, roleList);
        return ResultUtil.result(AdminSysConf.SUCCESS, map);
    }

    @ApiOperation(value = "获取当前用户的菜单", notes = "获取当前用户的菜单", response = String.class)
    @GetMapping(value = "/getMenu")
    public String getMenu(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Collection<Menu> categoryMenuList = new ArrayList<>();

        Admin admin = adminService.getAdminByUsername("admin");
        List<String> roleUid = new ArrayList<>();
        roleUid.add(admin.getRoleId());
        Collection<Role> roleList = new ArrayList<>();
        roleList.add(roleService.selectByPrimaryKey(admin.getRoleId()));
        List<String> categoryMenuIds = new ArrayList<>();

        Role role = adminService.getRoleByAdminId("4");
        String[] ids = role.getCategoryMenuIds().replace("[", "").replace("]", "").replace("\"", "").split(",");
        List<Menu> menus = adminService.getMenuByIds(ids);
        List<Menu> firstMenu = new ArrayList<>(20);
        List<Menu> secondMenu = new ArrayList<>(60);
        List<Menu> buttonList = new ArrayList<>(60);

        menus.forEach(item->{
            if(item.getMenuLevel() == AdminSysConf.ONE){
                firstMenu.add(item);
            }else if (item.getMenuLevel() == AdminSysConf.TWO){
                secondMenu.add(item);
            }else if (item.getMenuLevel() == AdminSysConf.THREE){
                buttonList.add(item);
            }
        });
        //对parent进行排序
        firstMenu.sort((a,b) -> Integer.compare(b.getMenuLevel(), a.getMenuLevel()));


        map.put(AdminSysConf.PARENT_LIST, firstMenu);
        map.put(AdminSysConf.SON_LIST, secondMenu);
        map.put(AdminSysConf.BUTTON_LIST, buttonList);
        return ResultUtil.result(AdminSysConf.SUCCESS, map);
    }

    /**
     * 设置登录限制，返回剩余次数
     * 密码错误五次，将会锁定10分钟
     *
     * @param request
     */
    private Integer setLoginCommit(HttpServletRequest request) {
        String ip = IpUtils.getIpAddr(request);
        String count = redisUtil.get(AdminRedisConf.LOGIN_LIMIT + AdminRedisConf.SEGMENTATION + ip);
        Integer surplusCount = 5;
        if (StringUtils.isNotEmpty(count)) {
            Integer countTemp = Integer.valueOf(count) + 1;
            surplusCount = surplusCount - countTemp;
            redisUtil.setEx(AdminRedisConf.LOGIN_LIMIT + AdminRedisConf.SEGMENTATION + ip, String.valueOf(countTemp), 10, TimeUnit.MINUTES);
        } else {
            surplusCount = surplusCount - 1;
            redisUtil.setEx(AdminRedisConf.LOGIN_LIMIT + AdminRedisConf.SEGMENTATION + ip, "1", 30, TimeUnit.MINUTES);
        }
        return surplusCount;
    }

}
