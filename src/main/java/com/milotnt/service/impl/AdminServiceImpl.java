package com.milotnt.service.impl;

import com.milotnt.mapper.AdminMapper;
import com.milotnt.pojo.Admin;
import com.milotnt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务实现类，提供管理员相关的业务逻辑处理。
 */
@Service
public class AdminServiceImpl implements AdminService {

    /**
     * 注入AdminMapper，用于数据库操作。
     */
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 管理员登录。
     * @param admin 包含账号和密码的管理员对象。
     * @return 如果找到匹配的管理员，则返回管理员对象，否则返回null。
     */
    @Override
    public Admin adminLogin(Admin admin) {
        return adminMapper.selectByAccountAndPassword(admin);
    }
}