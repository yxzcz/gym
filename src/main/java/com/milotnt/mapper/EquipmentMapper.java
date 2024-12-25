package com.milotnt.mapper;

import com.milotnt.pojo.Equipment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Mapper接口，用于定义与器材相关的数据库操作。
 */
@Mapper
public interface EquipmentMapper {

    /**
     * 查询所有器械信息。
     * @return 返回包含所有器械信息的列表。
     */
    List<Equipment> findAll();

    /**
     * 根据器械ID删除器械。
     * @param equipmentId 器械ID。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean deleteByEquipmentId(Integer equipmentId);

    /**
     * 添加新器械。
     * @param equipment 器械对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean insertEquipment(Equipment equipment);

    /**
     * 根据器械ID修改器械信息。
     * @param equipment 器械对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean updateEquipmentByEquipmentId(Equipment equipment);

    /**
     * 根据器械ID查询器械。
     * @param equipmentId 器械ID。
     * @return 返回包含特定器械信息的列表。
     */
    List<Equipment> selectByEquipmentId(Integer equipmentId);

    /**
     * 查询器械总数。
     * @return 返回器械总数。
     */
    Integer selectTotalCount();

}
