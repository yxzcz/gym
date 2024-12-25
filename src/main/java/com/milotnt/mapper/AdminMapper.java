package com.milotnt.mapper;

import com.milotnt.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper接口，用于定义与管理员相关的数据库操作。
 */
@Mapper
public interface AdminMapper {

    /**
     * 根据账号和密码查询管理员。
     * @param admin 包含账号和密码的管理员对象。
     * @return 查询到的管理员对象，如果不存在则返回null。
     */
    Admin selectByAccountAndPassword(Admin admin);

}