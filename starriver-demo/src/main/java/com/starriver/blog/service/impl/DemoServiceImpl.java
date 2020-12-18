package com.starriver.blog.service.impl;

import com.starriver.blog.mapper.TAdminMapper;
import com.starriver.blog.model.TAdmin;
import com.starriver.blog.model.TAdminExample;
import com.starriver.blog.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen
 * @describe DemoServiceImpl
 * @date 2020/12/18
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private TAdminMapper adminMapper;

    @Override
    public List<TAdmin> listAllAdmin() {
        return adminMapper.selectByExample(new TAdminExample());
    }
}
