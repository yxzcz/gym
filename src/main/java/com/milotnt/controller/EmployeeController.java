package com.milotnt.controller;

import com.milotnt.pojo.Employee;
import com.milotnt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 控制器类，用于处理员工相关的请求。
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    /**
     * 注入员工服务。
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询所有员工。
     * @param model 模型对象，用于向视图传递数据。
     * @return 视图名称 "selectEmployee"。
     */
    @RequestMapping("/selEmployee")
    public String selectEmployee(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "selectEmployee";
    }

    /**
     * 跳转到新增员工页面。
     * @return 视图名称 "addEmployee"。
     */
    @RequestMapping("/toAddEmployee")
    public String toAddEmployee() {
        return "addEmployee";
    }

    /**
     * 新增员工。
     * @param employee 员工对象。
     * @return 重定向到查询员工的页面。
     */
    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee) {
        // 工号随机生成
        Random random = new Random();
        String account1 = "1010";
        for (int i = 0; i < 5; i++) {
            account1 += random.nextInt(10);
        }
        Integer account = Integer.parseInt(account1);

        // 获取当前日期
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDay = simpleDateFormat.format(date);

        employee.setEmployeeAccount(account);
        employee.setEntryTime(nowDay);

        employeeService.insertEmployee(employee);

        return "redirect:selEmployee";
    }

    /**
     * 删除员工。
     * @param employeeAccount 员工账号。
     * @return 重定向到查询员工的页面。
     */
    @RequestMapping("/delEmployee")
    public String deleteEmployee(Integer employeeAccount) {
        employeeService.deleteByEmployeeAccount(employeeAccount);
        return "redirect:selEmployee";
    }

    /**
     * 跳转到员工修改页面。
     * @param employeeAccount 员工账号。
     * @param model 模型对象，用于向视图传递数据。
     * @return 视图名称 "updateEmployee"。
     */
    @RequestMapping("/toUpdateEmployee")
    public String toUpdateEmployee(Integer employeeAccount, Model model) {
        List<Employee> employeeList = employeeService.selectByEmployeeAccount(employeeAccount);
        model.addAttribute("employeeList", employeeList);
        return "updateEmployee";
    }

    /**
     * 修改员工信息。
     * @param employee 员工对象。
     * @return 重定向到查询员工的页面。
     */
    @RequestMapping("/updateEmployee")
    public String updateEmployee(Employee employee) {
        employeeService.updateMemberByEmployeeAccount(employee);
        return "redirect:selEmployee";
    }

}