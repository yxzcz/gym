package com.milotnt.service.impl;

import com.milotnt.mapper.ClassTableMapper;
import com.milotnt.pojo.ClassTable;
import com.milotnt.service.ClassTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类，提供课程表相关的业务逻辑处理。
 */
@Service
public class ClassTableServiceImpl implements ClassTableService {

    /**
     * 注入ClassTableMapper，用于数据库操作。
     */
    @Autowired
    private ClassTableMapper classTableMapper;

    /**
     * 查询所有课程信息。
     * @return 返回所有课程的列表。
     */
    @Override
    public List<ClassTable> findAll() {
        return classTableMapper.findAll();
    }

    /**
     * 根据课程ID删除课程。
     * @param classId 课程ID。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean deleteClassByClassId(Integer classId) {
        return classTableMapper.deleteClassByClassId(classId);
    }

    /**
     * 添加新课程。
     * @param classTable 课程对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean insertClass(ClassTable classTable) {
        return classTableMapper.insertClass(classTable);
    }

    /**
     * 根据课程ID查询课程。
     * @param classId 课程ID。
     * @return 返回对应课程ID的课程对象。
     */
    @Override
    public ClassTable selectByClassId(Integer classId) {
        return classTableMapper.selectByClassId(classId);
    }

    /**
     * 根据课程ID删除已预约的课程。
     * @param classId 课程ID。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean deleteOrderByClassId(Integer classId) {
        return classTableMapper.deleteOrderByClassId(classId);
    }
}