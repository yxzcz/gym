package com.milotnt.mapper;

import com.milotnt.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Mapper接口，用于定义与员工相关的数据库操作。
 */
@Mapper
public interface EmployeeMapper {

    /**
     * 查询所有员工信息。
     * @return 返回包含所有员工信息的列表。
     */
    List<Employee> findAll();

    /**
     * 根据员工账号删除员工。
     * @param employeeAccount 员工账号。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean deleteByEmployeeAccount(Integer employeeAccount);

    /**
     * 添加新员工。
     * @param employee 员工对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean insertEmployee(Employee employee);

    /**
     * 根据员工账号修改员工信息。
     * @param employee 员工对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    Boolean updateMemberByEmployeeAccount(Employee employee);

    /**
     * 根据员工账号查询员工。
     * @param employeeAccount 员工账号。
     * @return 返回包含特定员工信息的列表。
     */
    List<Employee> selectByEmployeeAccount(Integer employeeAccount);

    /**
     * 查询员工总数。
     * @return 返回员工总数。
     */
    Integer selectTotalCount();

}