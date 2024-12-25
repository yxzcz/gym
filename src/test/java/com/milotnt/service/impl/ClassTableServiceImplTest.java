package com.milotnt.service.impl;

import com.milotnt.mapper.ClassTableMapper;
import com.milotnt.pojo.ClassTable;
import com.milotnt.service.ClassTableService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClassTableServiceImplTest {

    @Autowired
    private ClassTableService classTableService; // 注入ClassTableService

    @Autowired
    private ClassTableMapper classTableMapper; // 注入ClassTableMapper

    private ClassTable testClassTable; // 测试数据

    @BeforeEach
    public void setUp() {
        // 初始化测试数据，在每个测试方法运行前执行
        testClassTable = new ClassTable();
        testClassTable.setClassId(13); // 使用固定的ID，确保在测试中唯一
        testClassTable.setClassName("增肌3");
        testClassTable.setClassBegin("2024年1月1日 15:00");
        testClassTable.setClassTime("60分钟");
        testClassTable.setCoach("增肌教练");

        // 清理数据库，确保没有重复的主键
        classTableMapper.deleteClassByClassId(testClassTable.getClassId());
    }

    @Test
    void insertClass() {
        // 测试添加课程功能
        Boolean result = classTableService.insertClass(testClassTable);
        assertTrue(result, "课程添加失败"); // 验证添加结果是否为 true
    }


    @Test
    void selectByClassId() {
        // 测试根据课程ID查询课程功能
        Boolean insertResult = classTableService.insertClass(testClassTable);
        assertTrue(insertResult, "课程添加失败");

        ClassTable result = classTableService.selectByClassId(testClassTable.getClassId());
        assertNotNull(result, "根据课程ID查询课程失败");
        assertEquals(testClassTable.getClassName(), result.getClassName(), "查询结果课程名称不匹配");
    }


    @Test
    void findAll() {
        // 测试查询所有课程信息功能
        Boolean insertResult = classTableService.insertClass(testClassTable);
        assertTrue(insertResult, "课程添加失败");

        List<ClassTable> result = classTableService.findAll();
        assertNotNull(result, "查询所有课程信息失败");
        assertFalse(result.isEmpty(), "课程列表应该包含至少一条数据");
    }
}