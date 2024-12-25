package com.milotnt.service.impl;

import com.milotnt.mapper.ClassOrderMapper;
import com.milotnt.pojo.ClassOrder;
import com.milotnt.service.ClassOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类，提供课程订单相关的业务逻辑处理。
 */
@Service
public class ClassOrderServiceImpl implements ClassOrderService {

    /**
     * 注入ClassOrderMapper，用于数据库操作。
     */
    @Autowired
    private ClassOrderMapper classOrderMapper;

    /**
     * 查询所有课程订单信息。
     * @return 返回所有课程订单的列表。
     */
    @Override
    public List<ClassOrder> findAll() {
        return classOrderMapper.findAll();
    }

    /**
     * 添加课程订单信息。
     * @param classOrder 课程订单对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean insertClassOrder(ClassOrder classOrder) {
        return classOrderMapper.insertClassOrder(classOrder);
    }

    /**
     * 根据会员账号查询个人报名课表。
     * @param memberAccount 会员账号。
     * @return 返回该会员账号下所有报名课程的列表。
     */
    @Override
    public List<ClassOrder> selectClassOrderByMemberAccount(Integer memberAccount) {
        return classOrderMapper.selectClassOrderByMemberAccount(memberAccount);
    }

    /**
     * 删除已预约的课程。
     * @param classOrderId 课程订单ID。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean deleteByClassOrderId(Integer classOrderId) {
        return classOrderMapper.deleteByClassOrderId(classOrderId);
    }

    /**
     * 查询会员是否报名该课程。
     * @param classId 课程ID。
     * @param memberAccount 会员账号。
     * @return 返回该会员是否报名该课程的订单对象，如果未报名则返回null。
     */
    @Override
    public ClassOrder selectMemberByClassIdAndMemberAccount(Integer classId, Integer memberAccount) {
        return classOrderMapper.selectMemberByClassIdAndMemberAccount(classId, memberAccount);
    }

    /**
     * 根据课程 id 查询所有报名的会员。
     * @param classId 课程ID。
     * @return 返回该课程下所有报名会员的列表。
     */
    @Override
    public List<ClassOrder> selectMemberOrderList(Integer classId) {
        return classOrderMapper.selectMemberOrderList(classId);
    }
}