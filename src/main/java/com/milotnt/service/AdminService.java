package com.milotnt.service;

import com.milotnt.pojo.Admin;

/**
 * 服务接口，定义管理员相关的业务操作。
 */
public interface AdminService {

    /**
     * 管理员登录。
     * @param admin 包含账号和密码的管理员对象。
     * @return 如果找到匹配的管理员，则返回管理员对象，否则返回null。
     */
    Admin adminLogin(Admin admin);
}