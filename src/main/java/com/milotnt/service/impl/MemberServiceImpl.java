package com.milotnt.service.impl;

import com.milotnt.mapper.MemberMapper;
import com.milotnt.pojo.Member;
import com.milotnt.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类，提供会员相关的业务逻辑处理。
 */
@Service
public class MemberServiceImpl implements MemberService {

    /**
     * 注入MemberMapper，用于数据库操作。
     */
    @Autowired
    private MemberMapper memberMapper;

    /**
     * 查询所有会员信息。
     * @return 返回包含所有会员信息的列表。
     */
    @Override
    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    /**
     * 新增会员信息。
     * @param member 会员对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean insertMember(Member member) {
        return memberMapper.insertMember(member);
    }

    /**
     * 根据会员账号修改会员信息。
     * @param member 会员对象。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean updateMemberByMemberAccount(Member member) {
        return memberMapper.updateMemberByMemberAccount(member);
    }

    /**
     * 用户登录，根据账号和密码查询会员信息。
     * @param member 包含账号和密码的会员对象。
     * @return 如果找到匹配的会员，则返回会员对象，否则返回null。
     */
    @Override
    public Member userLogin(Member member) {
        return memberMapper.selectByAccountAndPassword(member);
    }

    /**
     * 根据会员账号删除会员信息。
     * @param memberAccount 会员账号。
     * @return 返回操作结果，成功返回true，失败返回false。
     */
    @Override
    public Boolean deleteByMemberAccount(Integer memberAccount) {
        return memberMapper.deleteByMemberAccount(memberAccount);
    }

    /**
     * 查询会员总数。
     * @return 返回会员总数。
     */
    @Override
    public Integer selectTotalCount() {
        return memberMapper.selectTotalCount();
    }

    /**
     * 根据会员账号查询会员。
     * @param memberAccount 会员账号。
     * @return 返回包含特定会员信息的列表。
     */
    @Override
    public List<Member> selectByMemberAccount(Integer memberAccount) {
        return memberMapper.selectByMemberAccount(memberAccount);
    }
}