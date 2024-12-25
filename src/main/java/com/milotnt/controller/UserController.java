package com.milotnt.controller;

import com.milotnt.pojo.ClassOrder;
import com.milotnt.pojo.ClassTable;
import com.milotnt.pojo.Member;
import com.milotnt.service.ClassOrderService;
import com.milotnt.service.ClassTableService;
import com.milotnt.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 控制器类，用于处理用户相关的请求。
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 注入课程表服务。
     */
    @Autowired
    private ClassTableService classTableService;

    /**
     * 注入会员服务。
     */
    @Autowired
    private MemberService memberService;

    /**
     * 注入课程订单服务。
     */
    @Autowired
    private ClassOrderService classOrderService;

    /**
     * 跳转到个人信息页面。
     * @param model 模型对象，用于向视图传递数据。
     * @param session HttpSession对象，用于在会话中获取属性。
     * @return 视图名称 "userInformation"。
     */
    @RequestMapping("/toUserInfo")
    public String toUserInformation(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "userInformation";
    }

    /**
     * 跳转到修改个人信息页面。
     * @param session HttpSession对象，用于在会话中获取属性。
     * @param model 模型对象，用于向视图传递数据。
     * @return 视图名称 "updateUserInformation"。
     */
    @RequestMapping("/toUpdateInfo")
    public String toUpdateUserInformation(HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "updateUserInformation";
    }

    /**
     * 修改个人信息。
     * @param session HttpSession对象，用于在会话中获取属性。
     * @param member 会员对象。
     * @return 视图名称 "userInformation"。
     */
    @RequestMapping("/updateInfo")
    public String updateUserInformation(HttpSession session, Member member) {
        Member member1 = (Member) session.getAttribute("user");

        member.setMemberAccount(member1.getMemberAccount());
        member.setCardClass(member1.getCardClass());
        member.setCardTime(member1.getCardTime());
        member.setCardNextClass(member1.getCardNextClass());

        memberService.updateMemberByMemberAccount(member);
        return "userInformation";
    }

    /**
     * 跳转到我的课程页面。
     * @param model 模型对象，用于向视图传递数据。
     * @param session HttpSession对象，用于在会话中获取属性。
     * @return 视图名称 "userClass"。
     */
    @RequestMapping("/toUserClass")
    public String toUserClass(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        Integer memberAccount = member.getMemberAccount();
        List<ClassOrder> classOrderList = classOrderService.selectClassOrderByMemberAccount(memberAccount);
        model.addAttribute("classOrderList", classOrderList);
        return "userClass";
    }

    /**
     * 退课。
     * @param classOrderId 课程订单ID。
     * @return 重定向到我的课程页面。
     */
    @RequestMapping("delUserClass")
    public String deleteUserClass(Integer classOrderId) {
        classOrderService.deleteByClassOrderId(classOrderId);
        return "redirect:toUserClass";
    }

    /**
     * 跳转到报名选课页面。
     * @param model 模型对象，用于向视图传递数据。
     * @param session HttpSession对象，用于在会话中获取属性。
     * @return 视图名称 "userApplyClass"。
     */
    @RequestMapping("/toApplyClass")
    public String toUserApplyClass(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        List<ClassTable> classList = classTableService.findAll();
        model.addAttribute("member", member);
        model.addAttribute("classList", classList);
        return "userApplyClass";
    }

    /**
     * 报名选课。
     * @param classId 课程ID。
     * @param model 模型对象，用于向视图传递数据。
     * @param session HttpSession对象，用于在会话中获取属性。
     * @return 重定向到我的课程页面。
     */
    @RequestMapping("/applyClass")
    public String userApplyClass(Integer classId, Model model, HttpSession session) {
        ClassTable classTable = classTableService.selectByClassId(classId);
        Member member = (Member) session.getAttribute("user");

        Integer classId1 = classTable.getClassId();
        String className = classTable.getClassName();
        String coach = classTable.getCoach();
        String classBegin = classTable.getClassBegin();
        String memberName = member.getMemberName();
        Integer memberAccount = member.getMemberAccount();

        ClassOrder classOrder = new ClassOrder(classId1, className, coach, memberName, memberAccount, classBegin);
        Integer memberAccount1 = member.getMemberAccount();
        ClassOrder classOrder1 = classOrderService.selectMemberByClassIdAndMemberAccount(classId1, memberAccount1);

        if (classOrder1 == null) {
            classOrderService.insertClassOrder(classOrder);
        }

        return "redirect:toUserClass";
    }

}