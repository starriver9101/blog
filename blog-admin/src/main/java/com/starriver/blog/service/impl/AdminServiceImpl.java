package com.starriver.blog.service.impl;

import com.starriver.blog.CheckUtils;
import com.starriver.blog.JsonUtils;
import com.starriver.blog.RedisUtil;
import com.starriver.blog.dao.AdminRoleDao;
import com.starriver.blog.dto.AdminParam;
import com.starriver.blog.global.BaseSysConf;
import com.starriver.blog.mapper.AdminMapper;
import com.starriver.blog.model.Admin;
import com.starriver.blog.model.AdminExample;
import com.starriver.blog.model.Menu;
import com.starriver.blog.model.Role;
import com.starriver.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Name: AdminServiceImpl
 * @Description: AdminServiceImpl
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminRoleDao adminRoleDao;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public Admin getAdminByUsername(String username) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        if(CheckUtils.checkEmail(username)){
            criteria.andEmailEqualTo(username);
        }else if(CheckUtils.checkMobileNumber(username)){
            criteria.andMobileEqualTo(username);
        }else{
            criteria.andUsernameEqualTo(username);
        }
        List<Admin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public Admin register(AdminParam umsAdminParam) {
        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public String refreshToken(String oldToken) {
        return null;
    }

    @Override
    public Admin selectByPrimaryKey(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Admin> list(String keyword, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public int update(Long id, Admin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        return 0;
    }

    @Override
    public int updatePassword(AdminParam umsAdminParam) {
        return 0;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        return null;
//    }

//    @Override
//    public void addOnlineAdmin(Admin admin, String token, String roleName) {
//        HttpServletRequest request = RequestHolder.getRequest();
//        Map<String, String> map = IpUtils.getOsAndBrowserInfo(request);
//        String os = map.get(BaseSysConf.OS);
//        String browser = map.get(BaseSysConf.BROWSER);
//        String ip = IpUtils.getIpAddr(request);
//        OnlineAdmin onlineAdmin = new OnlineAdmin();
//        onlineAdmin.setAdminId(admin.getId());
//        onlineAdmin.setTokenId(token);
//        onlineAdmin.setOs(os);
//        onlineAdmin.setBrowser(browser);
//        onlineAdmin.setIpaddr(ip);
//        onlineAdmin.setLoginTime(DateUtils.getNowTime());
//        onlineAdmin.setRoleName(roleName);
//        onlineAdmin.setUserName(admin.getUsername());
//        //从Redis中获取IP来源
//        String jsonResult = redisUtil.get(BaseSysConf.IP_SOURCE + BaseRedisConf.SEGMENTATION + ip);
//        if (StringUtils.isEmpty(jsonResult)) {
//            String addresses = IpUtils.getAddresses(BaseSysConf.IP + BaseSysConf.EQUAL_TO + ip, BaseSysConf.UTF_8);
//            if (!StringUtils.isEmpty(addresses)) {
//                onlineAdmin.setLoginLocation(addresses);
//                redisUtil.setEx(BaseSysConf.IP_SOURCE + BaseRedisConf.SEGMENTATION + ip, addresses, 24, TimeUnit.HOURS);
//            }
//        } else {
//            onlineAdmin.setLoginLocation(jsonResult);
//        }
//        redisUtil.setEx(BaseRedisConf.LOGIN_TOKEN_KEY + BaseRedisConf.SEGMENTATION + token, JsonUtils.objectToJson(onlineAdmin), 30, TimeUnit.MINUTES);
//    }

    @Override
    public Role getRoleByAdminId(String adminId){
        return adminRoleDao.getRoleByAdminId(adminId);
    }

    @Override
    public List<Menu> getMenuByIds(String[] menuIds){
        return adminRoleDao.getMenuByIds(menuIds);
    }
}

