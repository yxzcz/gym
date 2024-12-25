package com.milotnt.service.impl;

import com.milotnt.mapper.AdminMapper;
import com.milotnt.pojo.Admin;
import com.milotnt.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test") // 指定使用test配置文件
@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    private AdminService adminService; // 注入AdminService

    private Admin testAdmin; // 测试数据

    @BeforeEach
    public void setUp() {
        // 初始化测试数据，在每个测试方法运行前执行
        testAdmin = new Admin();
        testAdmin.setAdminAccount(1001); // 假设账号为1
        testAdmin.setAdminPassword("123456"); // 假设密码为testPassword
    }

    @Test
    void adminLogin_success() {
        // 测试管理员登录功能，假设数据库中存在账号为1，密码为testPassword的管理员
        Admin result = adminService.adminLogin(testAdmin);
        assertNotNull(result, "管理员登录失败，返回结果为空");
        assertEquals(testAdmin.getAdminAccount(), result.getAdminAccount(), "管理员账号不匹配");
        assertEquals(testAdmin.getAdminPassword(), result.getAdminPassword(), "管理员密码不匹配");
    }

    @Test
    void adminLogin_failure() {
        // 测试管理员登录功能，假设数据库中不存在账号为2，密码为wrongPassword的管理员
        testAdmin.setAdminAccount(2); // 修改账号为2
        testAdmin.setAdminPassword("wrongPassword"); // 修改密码为wrongPassword
        Admin result = adminService.adminLogin(testAdmin);
        assertNull(result, "管理员登录成功，但预期应该失败");
    }
}