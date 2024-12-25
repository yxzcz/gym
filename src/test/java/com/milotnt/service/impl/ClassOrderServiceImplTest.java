package com.milotnt.service.impl;

import com.milotnt.mapper.ClassOrderMapper;
import com.milotnt.pojo.ClassOrder;
import com.milotnt.service.ClassOrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClassOrderServiceImplTest {

    @Autowired
    private ClassOrderService classOrderService; // 注入ClassOrderService

    @Autowired
    private ClassOrderMapper classOrderMapper; // 注入ClassOrderMapper

    private ClassOrder testClassOrder; // 测试数据

    @BeforeEach
    public void setUp() {
        // 动态生成唯一的课程订单ID
        int randomId = (int) (Math.random() * 1000000) + 100000;
        testClassOrder = new ClassOrder();
        testClassOrder.setClassOrderId(randomId); // 动态设置课程订单ID
        testClassOrder.setClassId(1); // 假设课程ID为1
        testClassOrder.setClassName("测试课程名称");
        testClassOrder.setCoach("测试教练");
        testClassOrder.setMemberName("测试会员");
        testClassOrder.setMemberAccount(1); // 假设会员账号为1
        testClassOrder.setClassBegin("测试课程开始时间");

        // 清理数据库，确保没有重复的主键
        classOrderService.deleteByClassOrderId(testClassOrder.getClassOrderId());
    }

    @Test
    @Transactional
    void insertClassOrder() {
        // 测试添加课程订单功能
        Boolean result = classOrderService.insertClassOrder(testClassOrder);
        assertTrue(result, "课程订单添加失败"); // 验证添加结果是否为 true
    }

    @Test
    @Transactional
    void deleteByClassOrderId() {
        // 测试根据课程订单ID删除课程订单功能
        // 首先添加一条课程订单数据
        classOrderService.insertClassOrder(testClassOrder);
        Boolean result = classOrderService.deleteByClassOrderId(testClassOrder.getClassOrderId());
        assertTrue(result, "根据课程订单ID删除课程订单失败"); // 验证删除结果是否为 true
    }

    @Test
    @Transactional
    void selectClassOrderByMemberAccount() {
        // 测试根据会员账号查询个人报名课表功能
        // 首先添加一条课程订单数据
        classOrderService.insertClassOrder(testClassOrder);
        List<ClassOrder> result = classOrderService.selectClassOrderByMemberAccount(testClassOrder.getMemberAccount());
        assertNotNull(result, "根据会员账号查询个人报名课表失败"); // 验证查询结果是否不为空
        assertFalse(result.isEmpty(), "查询结果应该是空"); // 验证查询结果不为空
        assertEquals(testClassOrder.getClassOrderId(), result.get(0).getClassOrderId(), "查询结果课程订单ID不匹配");
    }

    @Test
    @Transactional
    void selectMemberByClassIdAndMemberAccount() {
        // 测试查询会员是否报名该课程功能
        // 首先添加一条课程订单数据
        classOrderService.insertClassOrder(testClassOrder);
        ClassOrder result = classOrderService.selectMemberByClassIdAndMemberAccount(testClassOrder.getClassId(), testClassOrder.getMemberAccount());
        assertNotNull(result, "查询会员是否报名该课程失败"); // 验证查询结果是否不为空
        assertEquals(testClassOrder.getClassOrderId(), result.getClassOrderId(), "查询结果课程订单ID不匹配");
    }

    @Test
    @Transactional
    void findAll() {
        // 测试查询所有课程订单信息功能
        // 添加测试数据以确保列表不为空
        classOrderService.insertClassOrder(testClassOrder);
        List<ClassOrder> result = classOrderService.findAll();
        assertNotNull(result, "查询所有课程订单信息失败"); // 验证查询结果是否不为空
        assertFalse(result.isEmpty(), "课程订单列表应该包含至少一条数据");
    }

}