package com.milotnt.service.impl;

import com.milotnt.mapper.EmployeeMapper;
import com.milotnt.pojo.Employee;
import com.milotnt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类，提供员工相关的业务逻辑处理。
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * 注入EmployeeMapper，用于数据库操作。
     */
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询所有员工信息。
     * @return 返回包含所有员工信息的列表。
     */
    @Override
    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    /**
     * 根据员工账号删除员工。
     * @param employeeAccount 员工账号。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean deleteByEmployeeAccount(Integer employeeAccount) {
        return employeeMapper.deleteByEmployeeAccount(employeeAccount);
    }

    /**
     * 添加新员工。
     * @param employee 员工对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    /**
     * 根据员工账号修改员工信息。
     * @param employee 员工对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean updateMemberByEmployeeAccount(Employee employee) {
        return employeeMapper.updateMemberByEmployeeAccount(employee);
    }

    /**
     * 根据员工账号查询员工。
     * @param employeeAccount 员工账号。
     * @return 返回包含特定员工信息的列表。
     */
    @Override
    public List<Employee> selectByEmployeeAccount(Integer employeeAccount) {
        return employeeMapper.selectByEmployeeAccount(employeeAccount);
    }

    /**
     * 查询员工总数。
     * @return 返回员工总数。
     */
    @Override
    public Integer selectTotalCount() {
        return employeeMapper.selectTotalCount();
    }
}