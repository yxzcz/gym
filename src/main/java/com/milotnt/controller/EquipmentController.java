package com.milotnt.controller;

import com.milotnt.pojo.Equipment;
import com.milotnt.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 控制器类，用于处理器材相关的请求。
 */
@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    /**
     * 注入器材服务。
     */
    @Autowired
    private EquipmentService equipmentService;

    /**
     * 查询所有器材。
     * @param model 模型对象，用于向视图传递数据。
     * @return 视图名称 "selectEquipment"。
     */
    @RequestMapping("/selEquipment")
    public String selectEquipment(Model model) {
        List<Equipment> equipmentList = equipmentService.findAll();
        Integer totalCount = equipmentService.selectTotalCount();
        model.addAttribute("equipmentList", equipmentList);
        model.addAttribute("totalCount", totalCount); // 添加总数到模型
        return "selectEquipment";
    }

    /**
     * 删除器材。
     * @param equipmentId 器材ID。
     * @return 重定向到查询器材的页面。
     */
    @RequestMapping("/delEquipment")
    public String deleteEquipment(Integer equipmentId) {
        equipmentService.deleteByEquipmentId(equipmentId);
        return "redirect:/equipment/selEquipment";
    }

    /**
     * 跳转到修改器材页面。
     * @param equipmentId 器材ID。
     * @param model 模型对象，用于向视图传递数据。
     * @return 视图名称 "updateEquipment"。
     */
    @RequestMapping("/toUpdateEquipment")
    public String toUpdateEquipment(Integer equipmentId, Model model) {
        List<Equipment> equipmentList = equipmentService.selectByEquipmentId(equipmentId);
        model.addAttribute("equipmentList", equipmentList);
        return "updateEquipment";
    }

    /**
     * 修改器材信息。
     * @param equipment 器材对象。
     * @return 重定向到查询器材的页面。
     */
    @RequestMapping("/updateEquipment")
    public String updateEquipment(Equipment equipment) {
        equipmentService.updateEquipmentByEquipmentId(equipment);
        return "redirect:/equipment/selEquipment";
    }

    /**
     * 跳转到新增器材页面。
     * @return 视图名称 "addEquipment"。
     */
    @RequestMapping("/toAddEquipment")
    public String toAddEquipment() {
        return "addEquipment";
    }

    /**
     * 新增器材。
     * @param equipment 器材对象。
     * @return 重定向到查询器材的页面。
     */
    @RequestMapping("/addEquipment")
    public String addEquipment(Equipment equipment) {
        equipmentService.insertEquipment(equipment);
        return "redirect:/equipment/selEquipment";
    }

    /**
     * 获取器材总数。
     * @param model 模型对象，用于向视图传递数据。
     * @return 视图名称 "equipmentCount"。
     */
    @GetMapping("/count")
    public String getEquipmentCount(Model model) {
        Integer totalCount = equipmentService.selectTotalCount();
        model.addAttribute("totalCount", totalCount);
        return "equipmentCount";
    }

    /**
     * 导出器材信息到TXT文件。
     * @param response HTTP响应对象。
     * @throws IOException IO异常。
     */
    @GetMapping("/exportEquipments")
    public void exportEquipments(HttpServletResponse response) throws IOException {
        List<Equipment> equipmentList = equipmentService.findAll();
        response.setContentType("text/plain;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=equipments.txt");

        try (PrintWriter writer = response.getWriter()) {
            writer.println("Equipment ID, Equipment Name, Equipment Location, Equipment Status, Equipment Message");
            for (Equipment equipment : equipmentList) {
                writer.println(equipment.getEquipmentId() + "," +
                        equipment.getEquipmentName() + "," +
                        equipment.getEquipmentLocation() + "," +
                        equipment.getEquipmentStatus() + "," +
                        equipment.getEquipmentMessage());
            }
        }
    }
}