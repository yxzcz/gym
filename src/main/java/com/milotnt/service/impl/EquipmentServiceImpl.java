package com.milotnt.service.impl;

import com.milotnt.mapper.EquipmentMapper;
import com.milotnt.pojo.Equipment;
import com.milotnt.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类，提供器材相关的业务逻辑处理。
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

    /**
     * 注入EquipmentMapper，用于数据库操作。
     */
    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * 注入JdbcTemplate，用于JDBC数据库操作。
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询所有器材信息。
     * @return 返回包含所有器材信息的列表。
     */
    @Override
    public List<Equipment> findAll() {
        return equipmentMapper.findAll();
    }

    /**
     * 根据器材ID删除器材。
     * @param equipmentId 器材ID。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean deleteByEquipmentId(Integer equipmentId) {
        return equipmentMapper.deleteByEquipmentId(equipmentId);
    }

    /**
     * 添加新器材。
     * @param equipment 器材对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean insertEquipment(Equipment equipment) {
        return equipmentMapper.insertEquipment(equipment);
    }

    /**
     * 根据器材ID修改器材信息。
     * @param equipment 器材对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean updateEquipmentByEquipmentId(Equipment equipment) {
        return equipmentMapper.updateEquipmentByEquipmentId(equipment);
    }

    /**
     * 根据器材ID查询器材。
     * @param equipmentId 器材ID。
     * @return 返回包含特定器材信息的列表。
     */
    @Override
    public List<Equipment> selectByEquipmentId(Integer equipmentId) {
        return equipmentMapper.selectByEquipmentId(equipmentId);
    }

    /**
     * 查询器材总数。
     * @return 返回器材总数。
     */
    @Override
    public Integer selectTotalCount() {
        // 使用JdbcTemplate执行查询并返回结果
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM equipment", Integer.class);
    }
}