package com.milotnt.mapper;

import com.milotnt.pojo.ClassOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Mapper接口，用于定义与课程订单相关的数据库操作。
 */
@Mapper
public interface ClassOrderMapper {

    /**
     * 查询所有报名表信息。
     * @return 返回所有课程订单的列表。
     */
    List<ClassOrder> findAll();

    /**
     * 添加报名信息。
     * @param classOrder 课程订单对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean insertClassOrder(ClassOrder classOrder);

    /**
     * 根据会员账号查询个人报名课表。
     * @param memberAccount 会员账号。
     * @return 返回该会员账号下所有报名课程的列表。
     */
    List<ClassOrder> selectClassOrderByMemberAccount(Integer memberAccount);

    /**
     * 删除已预约的课程。
     * @param classOrderId 课程订单ID。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean deleteByClassOrderId(Integer classOrderId);

    /**
     * 查询会员是否报名该课程。
     * @param classId 课程ID。
     * @param memberAccount 会员账号。
     * @return 返回该会员是否报名该课程的订单对象，如果未报名则返回null。
     */
    ClassOrder selectMemberByClassIdAndMemberAccount(Integer classId, Integer memberAccount);

    /**
     * 根据课程 id 查询所有报名的会员。
     * @param classId 课程ID。
     * @return 返回该课程下所有报名会员的列表。
     */
    List<ClassOrder> selectMemberOrderList(Integer classId);

}