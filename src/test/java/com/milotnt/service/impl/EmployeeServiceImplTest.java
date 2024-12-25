package com.milotnt.service.impl;

import com.milotnt.mapper.EmployeeMapper;
import com.milotnt.pojo.Employee;
import com.milotnt.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService; // 注入EmployeeService

    @Autowired
    private EmployeeMapper employeeMapper; // 注入EmployeeMapper

    private Employee testEmployee; // 测试数据

    @BeforeEach
    public void setUp() {
        // 动态生成唯一的员工账号
        int randomAccount = (int) (Math.random() * 1000000) + 100000;
        testEmployee = new Employee();
        testEmployee.setEmployeeAccount(randomAccount); // 动态设置员工账号
        testEmployee.setEmployeeName("保洁5");
        testEmployee.setEmployeeGender("男");
        testEmployee.setEmployeeAge(40); // 假设员工年龄为30
        testEmployee.setEntryTime("2024-12-24");
        testEmployee.setStaff("保洁员");
        testEmployee.setEmployeeMessage("模范员工");

        // 清理数据库，确保没有重复的主键
        employeeService.deleteByEmployeeAccount(testEmployee.getEmployeeAccount());
    }

    @Test
    @Transactional
    void insertEmployee() {
        // 测试添加员工功能
        Boolean result = employeeService.insertEmployee(testEmployee);
        assertTrue(result, "员工添加失败"); // 验证添加结果是否为 true
    }

    @Test
    @Transactional
    void deleteByEmployeeAccount() {
        // 测试根据员工账号删除员工功能
        // 首先添加一条员工数据
        employeeService.insertEmployee(testEmployee);
        Boolean result = employeeService.deleteByEmployeeAccount(testEmployee.getEmployeeAccount());
        assertTrue(result, "根据员工账号删除员工失败"); // 验证删除结果是否为 true
    }

    @Test
    @Transactional
    void updateMemberByEmployeeAccount() {
        // 测试根据员工账号修改员工信息功能
        // 首先添加一条员工数据
        employeeService.insertEmployee(testEmployee);
        testEmployee.setEmployeeName("更新后的测试员工姓名"); // 修改员工姓名
        Boolean result = employeeService.updateMemberByEmployeeAccount(testEmployee);
        assertTrue(result, "根据员工账号修改员工信息失败"); // 验证更新结果是否为 true
    }

    @Test
    @Transactional
    void selectByEmployeeAccount() {
        // 测试根据员工账号查询员工功能
        // 首先添加一条员工数据
        employeeService.insertEmployee(testEmployee);
        List<Employee> result = employeeService.selectByEmployeeAccount(testEmployee.getEmployeeAccount());
        assertNotNull(result, "根据员工账号查询员工失败"); // 验证查询结果是否不为空
        assertFalse(result.isEmpty(), "查询结果应该是空"); // 验证查询结果不为空
        assertEquals(testEmployee.getEmployeeAccount(), result.get(0).getEmployeeAccount(), "查询结果员工账号不匹配");
    }

    @Test
    @Transactional
    void findAll() {
        // 测试查询所有员工信息功能
        // 添加测试数据以确保列表不为空
        employeeService.insertEmployee(testEmployee);
        List<Employee> result = employeeService.findAll();
        assertNotNull(result, "查询所有员工信息失败"); // 验证查询结果是否不为空
        assertFalse(result.isEmpty(), "员工列表应该包含至少一条数据");
    }

    @Test
    @Transactional
    void selectTotalCount() {
        // 测试查询员工总数功能
        // 添加测试数据以确保总数不为零
        employeeService.insertEmployee(testEmployee);
        Integer result = employeeService.selectTotalCount();
        assertNotNull(result, "查询员工总数失败"); // 验证查询结果是否不为空
        assertTrue(result >= 1, "员工总数应该至少为1");
    }
}