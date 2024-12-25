package com.milotnt.service;

import com.milotnt.pojo.ClassTable;
import java.util.List;

/**
 * 服务接口，定义课程表相关的业务操作。
 */
public interface ClassTableService {

    /**
     * 查询所有课程。
     * @return 返回所有课程的列表。
     */
    List<ClassTable> findAll();

    /**
     * 根据课程ID删除课程。
     * @param classId 课程ID。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean deleteClassByClassId(Integer classId);

    /**
     * 添加新课程。
     * @param classTable 课程对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean insertClass(ClassTable classTable);

    /**
     * 根据课程ID查询课表。
     * @param classId 课程ID。
     * @return 返回对应课程ID的课程对象。
     */
    ClassTable selectByClassId(Integer classId);

    /**
     * 根据课程ID删除已预约的课程。
     * @param classId 课程ID。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean deleteOrderByClassId(Integer classId);

}