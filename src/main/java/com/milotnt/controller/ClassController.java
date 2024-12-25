package com.milotnt.controller;

import com.milotnt.pojo.ClassOrder;
import com.milotnt.pojo.ClassTable;
import com.milotnt.service.ClassOrderService;
import com.milotnt.service.ClassTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 控制器类，用于处理课程相关的请求。
 */
@Controller
@RequestMapping("/class")
public class ClassController {

    // 创建一个Logger实例
    private static final Logger logger = LoggerFactory.getLogger(ClassController.class);

    /**
     * 注入课程表服务。
     */
    @Autowired
    private ClassTableService classTableService;

    /**
     * 注入课程订单服务。
     */
    @Autowired
    private ClassOrderService classOrderService;

    /**
     * 查询所有课程。
     * @param model 模型对象，用于向视图传递数据。
     * @return 视图名称 "selectClass"。
     */
    @RequestMapping("/selClass")
    public String selectClass(Model model) {
        logger.info("selectClass method is called");
        List<ClassTable> classList = classTableService.findAll();
        model.addAttribute("classList", classList);
        return "selectClass";
    }

    /**
     * 跳转到新增课程页面。
     * @return 视图名称 "addClass"。
     */
    @RequestMapping("/toAddClass")
    public String toAddClass() {
        logger.info("toAddClass method is called");
        return "addClass";
    }

    /**
     * 新增课程。
     * @param classTable 课程表对象。
     * @return 重定向到查询课程的页面。
     */
    @RequestMapping("/addClass")
    public String addClass(ClassTable classTable) {
        logger.info("addClass method is called with classTable: {}", classTable);
        classTableService.insertClass(classTable);
        return "redirect:selClass";
    }

    /**
     * 删除课程及其对应的订单。
     * @param classId 课程ID。
     * @return 重定向到查询课程的页面。
     */
    @RequestMapping("/delClass")
    public String deleteClass(Integer classId) {
        logger.info("deleteClass method is called with classId: {}", classId);
        classTableService.deleteClassByClassId(classId);
        classOrderService.deleteByClassOrderId(classId);
        return "redirect:selClass";
    }

    /**
     * 查询课程的报名信息。
     * @param classId 课程ID。
     * @param model 模型对象，用于向视图传递数据。
     * @return 视图名称 "selectClassOrder"。
     */
    @RequestMapping("/selClassOrder")
    public String selectClassOrder(Integer classId, Model model) {
        logger.info("selectClassOrder method is called with classId: {}", classId);
        List<ClassOrder> classOrderList = classOrderService.selectMemberOrderList(classId);
        model.addAttribute("classOrderList", classOrderList);
        return "selectClassOrder";
    }
}