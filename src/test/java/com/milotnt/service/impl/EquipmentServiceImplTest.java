package com.milotnt.service.impl;

import com.milotnt.mapper.EquipmentMapper;
import com.milotnt.pojo.Equipment;
import com.milotnt.service.EquipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EquipmentServiceImplTest {

    @Autowired
    private EquipmentService equipmentService; // 注入EquipmentService

    @Autowired
    private EquipmentMapper equipmentMapper; // 注入EquipmentMapper

    private Equipment testEquipment; // 测试数据

    @BeforeEach
    public void setUp() {
        // 动态生成唯一的器材ID
        int randomId = (int) (Math.random() * 1000000) + 100000;
        testEquipment = new Equipment();
        testEquipment.setEquipmentId(randomId); // 动态设置器材ID
        testEquipment.setEquipmentName("测试器材名称");
        testEquipment.setEquipmentLocation("测试器材位置");
        testEquipment.setEquipmentStatus("测试器材状态");
        testEquipment.setEquipmentMessage("测试器材备注信息");

        // 清理数据库，确保没有重复的主键
        equipmentService.deleteByEquipmentId(testEquipment.getEquipmentId());
    }

    @Test
    @Transactional
    void insertEquipment() {
        // 测试添加器材功能
        Boolean result = equipmentService.insertEquipment(testEquipment);
        assertTrue(result, "器材添加失败"); // 验证添加结果是否为 true
    }

    @Test
    @Transactional
    void deleteByEquipmentId() {
        // 测试根据器材ID删除器材功能
        // 首先添加一条器材数据
        equipmentService.insertEquipment(testEquipment);
        Boolean result = equipmentService.deleteByEquipmentId(testEquipment.getEquipmentId());
        assertTrue(result, "根据器材ID删除器材失败"); // 验证删除结果是否为 true
    }

    @Test
    @Transactional
    void updateEquipmentByEquipmentId() {
        // 测试根据器材ID修改器材信息功能
        // 首先添加一条器材数据
        equipmentService.insertEquipment(testEquipment);
        testEquipment.setEquipmentName("更新后的测试器材名称"); // 修改器材名称
        Boolean result = equipmentService.updateEquipmentByEquipmentId(testEquipment);
        assertTrue(result, "根据器材ID修改器材信息失败"); // 验证更新结果是否为 true
    }

    @Test
    @Transactional
    void selectByEquipmentId() {
        // 测试根据器材ID查询器材功能
        // 首先添加一条器材数据
        equipmentService.insertEquipment(testEquipment);
        List<Equipment> result = equipmentService.selectByEquipmentId(testEquipment.getEquipmentId());
        assertNotNull(result, "根据器材ID查询器材失败"); // 验证查询结果是否不为空
        assertFalse(result.isEmpty(), "查询结果应该是空"); // 验证查询结果不为空
        assertEquals(testEquipment.getEquipmentId(), result.get(0).getEquipmentId(), "查询结果器材ID不匹配");
    }

    @Test
    @Transactional
    void findAll() {
        // 测试查询所有器材信息功能
        // 添加测试数据以确保列表不为空
        equipmentService.insertEquipment(testEquipment);
        List<Equipment> result = equipmentService.findAll();
        assertNotNull(result, "查询所有器材信息失败"); // 验证查询结果是否不为空
        assertFalse(result.isEmpty(), "器材列表应该包含至少一条数据");
    }

    @Test
    @Transactional
    void selectTotalCount() {
        // 测试查询器材总数功能
        // 添加测试数据以确保总数不为零
        equipmentService.insertEquipment(testEquipment);
        Integer result = equipmentService.selectTotalCount();
        assertNotNull(result, "查询器材总数失败"); // 验证查询结果是否不为空
        assertTrue(result >= 1, "器材总数应该至少为1");
    }
}