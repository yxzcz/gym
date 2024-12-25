package com.milotnt.service.impl;

import com.milotnt.mapper.MemberMapper;
import com.milotnt.pojo.Member;
import com.milotnt.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    private MemberService memberService; // 注入MemberService

    @Autowired
    private MemberMapper memberMapper; // 注入MemberMapper

    private Member testMember; // 测试数据

    @BeforeEach
    public void setUp() {
        // 动态生成唯一的会员账号
        int randomAccount = (int) (Math.random() * 1000000) + 100000;
        testMember = new Member();
        testMember.setMemberAccount(randomAccount); // 动态设置会员账号
        testMember.setMemberName("测试会员");
        testMember.setMemberGender("男");
        testMember.setMemberAge(30); // 假设会员年龄为30
        testMember.setMemberHeight(175); // 假设会员身高为175cm
        testMember.setMemberWeight(70); // 假设会员体重为70kg
        testMember.setMemberPhone(1234567890L); // 假设会员电话为1234567890
        testMember.setCardTime("2025-12-31"); // 假设会员卡有效期至2025-12-31
        testMember.setCardClass(0); // 假设会员卡已上课次数为0
        testMember.setCardNextClass(10); // 假设会员卡剩余课次数为10

        // 清理数据库，确保没有重复的主键
        memberService.deleteByMemberAccount(testMember.getMemberAccount());
    }

    @Test
    @Transactional
    void insertMember() {
        // 测试添加会员功能
        Boolean result = memberService.insertMember(testMember);
        assertTrue(result, "会员添加失败"); // 验证添加结果是否为 true
    }

    @Test
    @Transactional
    void deleteByMemberAccount() {
        // 测试根据会员账号删除会员功能
        // 首先添加一条会员数据
        memberService.insertMember(testMember);
        Boolean result = memberService.deleteByMemberAccount(testMember.getMemberAccount());
        assertTrue(result, "根据会员账号删除会员失败"); // 验证删除结果是否为 true
    }

    @Test
    @Transactional
    void updateMemberByMemberAccount() {
        // 测试根据会员账号修改会员信息功能
        // 首先添加一条会员数据
        memberService.insertMember(testMember);
        testMember.setMemberName("更新后的测试会员"); // 修改会员姓名
        Boolean result = memberService.updateMemberByMemberAccount(testMember);
        assertTrue(result, "根据会员账号修改会员信息失败"); // 验证更新结果是否为 true
    }


    @Test
    @Transactional
    void findAll() {
        // 测试查询所有会员信息功能
        // 添加测试数据以确保列表不为空
        memberService.insertMember(testMember);
        List<Member> result = memberService.findAll();
        assertNotNull(result, "查询所有会员信息失败"); // 验证查询结果是否不为空
        assertFalse(result.isEmpty(), "会员列表应该包含至少一条数据");
    }

    @Test
    @Transactional
    void selectTotalCount() {
        // 测试查询会员总数功能
        // 添加测试数据以确保总数不为零
        memberService.insertMember(testMember);
        Integer result = memberService.selectTotalCount();
        assertNotNull(result, "查询会员总数失败"); // 验证查询结果是否不为空
        assertTrue(result >= 1, "会员总数应该至少为1");
    }
}