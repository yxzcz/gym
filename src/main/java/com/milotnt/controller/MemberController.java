package com.milotnt.controller;

import com.milotnt.pojo.Member;
import com.milotnt.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 控制器类，用于处理会员相关的请求。
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    /**
     * 注入会员服务。
     */
    @Autowired
    private MemberService memberService;

    /**
     * 查询所有会员。
     * @param model 模型对象，用于向视图传递数据。
     * @return 视图名称 "selectMember"。
     */
    @RequestMapping("/selMember")
    public String selectMember(Model model) {
        List<Member> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);
        return "selectMember";
    }

    /**
     * 跳转到新增会员页面。
     * @return 视图名称 "addMember"。
     */
    @RequestMapping("/toAddMember")
    public String toAddMember() {
        return "addMember";
    }

    /**
     * 新增会员。
     * @param member 会员对象。
     * @return 重定向到查询会员的页面。
     */
    @RequestMapping("/addMember")
    public String addMember(Member member) {
        // 会员账号&卡号随机生成
        Random random = new Random();
        String account1 = "2021";
        for (int i = 0; i < 5; i++) {
            account1 += random.nextInt(10);
        }
        Integer account = Integer.parseInt(account1);

        // 初始密码加密
        String password = "123456";
        member.setMemberPassword(member.encryptPassword(password)); // 使用加密方法

        // 获取当前日期
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDay = simpleDateFormat.format(date);

        Integer nextClass = member.getCardClass();

        member.setMemberAccount(account);
        member.setCardTime(nowDay);
        member.setCardNextClass(nextClass);

        memberService.insertMember(member);

        return "redirect:selMember";
    }

    /**
     * 删除会员。
     * @param memberAccount 会员账号。
     * @return 重定向到查询会员的页面。
     */
    @RequestMapping("/delMember")
    public String deleteMember(Integer memberAccount) {
        memberService.deleteByMemberAccount(memberAccount);
        return "redirect:selMember";
    }

    /**
     * 跳转到会员修改页面。
     * @param memberAccount 会员账号。
     * @param model 模型对象，用于向视图传递数据。
     * @return 视图名称 "updateMember"。
     */
    @RequestMapping("/toUpdateMember")
    public String toUpdateMember(Integer memberAccount, Model model) {
        List<Member> memberList = memberService.selectByMemberAccount(memberAccount);
        model.addAttribute("memberList", memberList);
        return "updateMember";
    }

    /**
     * 修改会员信息。
     * @param member 会员对象。
     * @return 重定向到查询会员的页面。
     */
    @RequestMapping("/updateMember")
    public String updateMember(Member member) {
        memberService.updateMemberByMemberAccount(member);
        return "redirect:selMember";
    }

    /**
     * 跳转到会员卡查询页面。
     * @return 视图名称 "selectByMemberAccount"。
     */
    @RequestMapping("/toSelByCard")
    public String toSelectByCardId() {
        return "selectByMemberAccount";
    }

    /**
     * 根据会员卡号查询会员。
     * @param model 模型对象，用于向视图传递数据。
     * @param memberAccount 会员账号。
     * @return 视图名称 "selectByMemberAccount"，如果会员不存在则添加错误消息。
     */
    @RequestMapping("/selByCard")
    public String selectByCardId(Model model, Integer memberAccount) {
        List<Member> memberList = memberService.selectByMemberAccount(memberAccount);
        if (memberList != null) {
            model.addAttribute("memberList", memberList);
        } else {
            String message = "会员卡号不存在！";
            model.addAttribute("noMessage", message);
        }
        return "selectByMemberAccount";
    }
}