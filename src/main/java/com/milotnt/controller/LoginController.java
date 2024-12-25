package com.milotnt.controller;

import com.milotnt.pojo.Admin;
import com.milotnt.pojo.Member;
import com.milotnt.service.AdminService;
import com.milotnt.service.EmployeeService;
import com.milotnt.service.EquipmentService;
import com.milotnt.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 控制器类，用于处理登录相关的请求。
 */
@Controller
public class LoginController {

    /**
     * 注入会员服务。
     */
    @Autowired
    private MemberService memberService;
    /**
     * 注入管理员服务。
     */
    @Autowired
    private AdminService adminService;
    /**
     * 注入员工服务。
     */
    @Autowired
    private EmployeeService employeeService;
    /**
     * 注入器材服务。
     */
    @Autowired
    private EquipmentService equipmentService;

    /**
     * 跳转到管理员登录页面。
     * @return 视图名称 "adminLogin"。
     */
    @RequestMapping("/")
    public String toAdminLogin() {
        return "adminLogin";
    }

    /**
     * 跳转到会员登录页面。
     * @return 视图名称 "userLogin"。
     */
    @RequestMapping("/toUserLogin")
    public String toUserLogin() {
        return "userLogin";
    }

    /**
     * 管理员登录。
     * @param admin 管理员对象。
     * @param model 模型对象，用于向视图传递数据。
     * @param session HttpSession对象，用于在会话中设置属性。
     * @return 登录成功返回 "adminMain"，失败返回 "adminLogin"。
     */
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin admin, Model model, HttpSession session) {
        Admin admin1 = adminService.adminLogin(admin);
        if (admin1 != null) {
            // 会员人数
            Integer memberTotal = memberService.selectTotalCount();
            model.addAttribute("memberTotal", memberTotal);
            session.setAttribute("memberTotal", memberTotal);

            // 员工人数
            Integer employeeTotal = employeeService.selectTotalCount();
            model.addAttribute("employeeTotal", employeeTotal);
            session.setAttribute("employeeTotal", employeeTotal);

            // 健身房总人数
            Integer humanTotal = memberTotal + employeeTotal;
            model.addAttribute("humanTotal", humanTotal);
            session.setAttribute("humanTotal", humanTotal);

            // 器材数
            Integer equipmentTotal = equipmentService.selectTotalCount();
            model.addAttribute("equipmentTotal", equipmentTotal);
            session.setAttribute("equipmentTotal", equipmentTotal);

            return "adminMain";
        }
        model.addAttribute("msg", "您输入的账号或密码有误，请重新输入！");
        return "adminLogin";
    }

    /**
     * 会员登录。
     * @param member 会员对象。
     * @param model 模型对象，用于向视图传递数据。
     * @param session HttpSession对象，用于在会话中设置属性。
     * @return 登录成功返回 "userMain"，失败返回 "userLogin"。
     */
    @RequestMapping("/userLogin")
    public String userLogin(Member member, Model model, HttpSession session) {
        Member member1 = memberService.userLogin(member);
        if (member1 != null) {
            model.addAttribute("member", member1);
            session.setAttribute("user", member1);
            return "userMain";
        }
        model.addAttribute("msg", "您输入的账号或密码有误，请重新输入！");
        return "userLogin";
    }

    /**
     * 跳转到管理员主页。
     * @param model 模型对象，用于向视图传递数据。
     * @param session HttpSession对象，用于在会话中获取属性。
     * @return 视图名称 "adminMain"。
     */
    @RequestMapping("/toAdminMain")
    public String toAdminMain(Model model, HttpSession session) {
        Integer memberTotal = (Integer) session.getAttribute("memberTotal");
        Integer employeeTotal = (Integer) session.getAttribute("employeeTotal");
        Integer humanTotal = (Integer) session.getAttribute("humanTotal");
        Integer equipmentTotal = (Integer) session.getAttribute("equipmentTotal");
        model.addAttribute("memberTotal", memberTotal);
        model.addAttribute("employeeTotal", employeeTotal);
        model.addAttribute("humanTotal", humanTotal);
        model.addAttribute("equipmentTotal", equipmentTotal);
        return "adminMain";
    }

    /**
     * 跳转到会员主页。
     * @param model 模型对象，用于向视图传递数据。
     * @param session HttpSession对象，用于在会话中获取属性。
     * @return 视图名称 "userMain"。
     */
    @RequestMapping("/toUserMain")
    public String toUserMain(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "userMain";
    }

}